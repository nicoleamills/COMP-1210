import java.util.Scanner;
 /**
 * App that reads in user input values to create ellipsoid.
 * Project 4
 * @author Nicole Mills - CSPC 1210 - Summer
 * @version 06.19.21
 */ 
public class EllipsoidApp {
/** 
   * Project Description.
   * @param args not used.
   */

   public static void main(String[] args) {
       
      Ellipsoid ellipsoid1 = new Ellipsoid("", 0, 0, 0);
   
   // scanner for input
      Scanner input = new Scanner(System.in);
   
   // Ask user for input label abc
      System.out.println("Enter label and axes a, b, c for an ellipsoid. ");
      System.out.print("\tlabel: ");
      String label = input.nextLine();
   
   // a
      System.out.print("\ta: ");
      double a = Double.parseDouble(input.next());
      if (!ellipsoid1.setA(a)) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
   
   // b
      System.out.print("\tb: ");
      double b = Double.parseDouble(input.next());
      if (!ellipsoid1.setB(b)) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
   
   // c
      System.out.print("\tc: ");
      double c = Double.parseDouble(input.next());
      if (!ellipsoid1.setC(c)) {
         System.out.println("Error: axis value must be positive.");
         return;
      }
   
      ellipsoid1 = new Ellipsoid(label, a, b, c);
      System.out.println("\n" + ellipsoid1);
   
   
   }
}