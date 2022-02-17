import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class EllipsoidListMenuApp {
   public static void main(String[] args) throws IOException {
      //instance variables
      String aCode = "";
      String eFileName = "";
      String eListName = "";
      String sLabel = "";
      double dA = 0; double dB = 0; double dC = 0;
      String SLabelIn = "";
      double dAIn = 0; double dBIn = 0; double dIn = 0;
      
      ArrayList<Ellipsoid> myList = new ArrayList<Ellipsoid>();
      EllipsoidList myEList = new EllipsoidList(eListName, myList);
      
      Scanner scan = new Scanner(System.in);
   
      // print out the menu
      System.out.println("Ellipsoid List System Menu ");
      System.out.println("R - Read File and Create Ellipsoid List ");
      System.out.println("P - Print Ellipsoid List ");
      System.out.println("S - Primy Summary ");
      System.out.println("A - Add Ellipsoid ");
      System.out.println("D - Delete Ellipsoid ");
      System.out.println("F - Find Ellipsoid ");
      System.out.println("E - Edit Ellipsoid ");
      System.out.println("Q - Quit ");
   
   
   // menu initiliazation
      do {
         System.out.println("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         aCode = scan.nextLine();
         aCode = aCode.trim();
         
         if (aCode.length() == 0) {
            continue;
         }
      // begin char switch statement
         char aCodeChar = aCode.charAt(0);
         switch (aCodeChar) {
            case 'R':
            case 'r':
               System.out.println("\tFile Name: ");
               eFileName = scan.nextLine();
               myEList = myEList.readFile(eFileName);
               System.out.println("File read in and Ellipsoid List created");
               System.out.println("");
            
            case 'P':
            case 'p':
               System.out.println(myDList);
               break;
               
            case 'S':
            case 's':
               System.out.println(myDList.summaryInfo());
               System.out.println("");
               break;
           
            case 'A':
            case 'a':
               System.out.println("\tlabel ");
               sLabel = scan.nextLine();
               System.out.println("\ta: ");
               dA = Double.parseDouble(scan.nextLine());
               System.out.println("\tb: ");
               dB = Double.parseDouble(scan.nextLine());
               System.out.println("\tc: ");
               dC = Double.parseDouble(scan.nextLine());
            
               myEList.addEllipsoid(sLabel, dA, dB, dC);
               System.out.println("\t*** Ellipsoid added ***");
           
         }
      
      }
      while (aCode.equalsIgnoreCase("Q"));
   }
}