import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/** 
* Creates EllipsoidList class and returns summary info.
* Project 05.
* @author Nicole Mills - CSPC 1210 - Summer.
* @version 06.26.21
*/
public class EllipsoidListApp {
/**
* Creating an EllipsoidList object.
* @param args not used
* @throws FileNotFoundException just in case
*/
   public static void main(String[] args) throws FileNotFoundException {
   // new scanner in
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: ");
      String filename = scan.nextLine();
   
   // close keyboard
      scan.close();
      System.out.println();
   
      ArrayList<Ellipsoid> ellipList = new ArrayList<Ellipsoid>();
   
      Scanner infile = new Scanner(new File(filename));
   
   // store in local var
      String name = infile.nextLine();
   
      while (infile.hasNext()) {
         String newname = infile.nextLine();
         double a = infile.nextDouble();
         double b = infile.nextDouble();
         double c = infile.nextDouble();
         if (infile.hasNext()) {
            infile.nextLine(); 
         }
         ellipList.add(new Ellipsoid(newname, a, b, c));
         
      }
      infile.close();
      
      
      // Create EllipsoidList object
      EllipsoidList app = new EllipsoidList(name, ellipList);
                // print to string
      System.out.println(app.toString());
      System.out.println();
                // print summary
      System.out.println(app.summaryInfo());
   }
   

}