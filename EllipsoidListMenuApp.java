import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
/** 
* Creates EllipsoidListMenu App.
* Project 06.
* @author Nicole Mills - CSPC 1210 - Summer.
* @version 07.02.21
*/
public class EllipsoidListMenuApp {
/**
 * Create a menu app to read input and show output.
 * @param args Command line arguments - not used.
 * @throws FileNotFoundException in case.
 */
   public static void main(String[] args) throws FileNotFoundException {
      //instance variables
      String aCode = "";
      String eFileName = "";
      String eListName = "";
      String sLabel = "";
      double dA = 0; double dB = 0; double dC = 0;
      String sLabelIn = "";
      double dAIn = 0; double dBIn = 0; double dCIn = 0;
      
      ArrayList<Ellipsoid> myList = new ArrayList<Ellipsoid>();
      EllipsoidList myEList = new EllipsoidList(eListName, myList);
      
      Scanner scan = new Scanner(System.in);
   
      // print out the menu
      System.out.println("Ellipsoid List System Menu");
      System.out.println("R - Read File and Create Ellipsoid List");
      System.out.println("P - Print Ellipsoid List");
      System.out.println("S - Print Summary");
      System.out.println("A - Add Ellipsoid");
      System.out.println("D - Delete Ellipsoid");
      System.out.println("F - Find Ellipsoid");
      System.out.println("E - Edit Ellipsoid");
      System.out.println("Q - Quit");
   
   
   // menu initiliazation
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
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
               System.out.print("\tFile Name: ");
               eFileName = scan.nextLine();
               try {
                  myEList = myEList.readFile(eFileName);
               } 
               catch (FileNotFoundException e) {
                  System.out.println("Error- file not found.");
               }
               System.out.println("\tFile read in and Ellipsoid List created");
               System.out.println("");
               break;
            
            case 'P':
            case 'p':
               System.out.println(myEList);
               break;
               
            case 'S':
            case 's':
               System.out.println(myEList.summaryInfo());
               System.out.println("");
               break;
           
            case 'A':
            case 'a':
               System.out.print("\tlabel: ");
               sLabel = scan.nextLine();
               System.out.print("\ta: ");
               dA = Double.parseDouble(scan.nextLine());
               System.out.print("\tb: ");
               dB = Double.parseDouble(scan.nextLine());
               System.out.print("\tc: ");
               dC = Double.parseDouble(scan.nextLine());
            
               myEList.addEllipsoid(sLabel, dA, dB, dC);
               System.out.println("\t*** Ellipsoid added ***");
               System.out.println("");
               break;
            
            
            case 'D':
            case 'd':
               System.out.print("\tlabel: ");
               sLabelIn = scan.nextLine();
            
               if (myEList.deleteEllipsoid(sLabelIn) == null) {
                  System.out.print("\t\"" 
                     + sLabelIn.substring(0, 1).toUpperCase()
                     + sLabelIn.substring(1) + "\" not found\n");
                  System.out.println("");
               }
               else {
                  System.out.println("\t\"" 
                     + sLabelIn.substring(0, 1).toUpperCase()
                     + sLabelIn.substring(1) + "\" deleted");
                  System.out.println("");
               }
               break;
            
            case 'F':
            case 'f':
               System.out.print("\tlabel: ");
               sLabelIn = scan.nextLine();
            
               if (myEList.findEllipsoid(sLabelIn) == null) {
                  System.out.print("\t\"" 
                     + sLabelIn.substring(0, 1).toUpperCase()
                     + sLabelIn.substring(1)
                     + "\" not found" + "\n");
                  System.out.println("");
               }
               else {
                  System.out.print(myEList.findEllipsoid(sLabelIn)
                     .toString() + "\n");
                  System.out.println("");
               }
               break;
           
           
            case 'E':
            case 'e':
               System.out.print("\tlabel: ");
               sLabelIn = scan.nextLine();
               System.out.print("\ta: ");
               dAIn = Double.parseDouble(scan.nextLine());
               System.out.print("\tb: ");
               dBIn = Double.parseDouble(scan.nextLine());
               System.out.print("\tc: ");
               dCIn = Double.parseDouble(scan.nextLine());
            
               if (myEList.editEllipsoid(sLabelIn, dAIn, dBIn, dCIn) == null) {
                  System.out.println("\t\"" 
                     + sLabelIn.substring(0, 1).toUpperCase()
                     + sLabelIn.substring(1) + "\" not found");
                  System.out.println("");
               }
               else {
                  System.out.println("\t\"" 
                     + sLabelIn.substring(0, 1).toUpperCase()
                     + sLabelIn.substring(1)
                     + "\" successfully edited");
                  System.out.println("");
               }
               break;
           
            case 'Q':
            case 'q':
               break;
           
            default: 
               System.out.println("\t*** invalid code ***");
               System.out.println("");
               break;
         }
      
      }
      while (!aCode.equalsIgnoreCase("Q"));
   }
}