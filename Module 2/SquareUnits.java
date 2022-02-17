/** Finding the expression program.
* Project 2
* @author Nicole Mills - CSPC 1210 - Summer
* @version 06.02.21
*/
import java.util.Scanner;
/** Demonstrates the use of the Scanner class to.
* read numeric data input by user and convert
* to various data values.
*/
public class SquareUnits {
 /**
 * Create a Scanner class object to read input.
 * @param args Command line arguments - not used.
 */
   public static void main(String[] args) {
   
      int acres = 0;
      int sqyards = 0;
      int sqfeet = 0;
      int sqin = 0;
      
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Enter the area in square inches: ");
      sqin = scan.nextInt();
      
      if (sqin > 1_000_000_000) {
         System.out.println("Limit of 1,000,000,000 square inches exceeded!");
      }
      else {
         System.out.println("Number of Units: ");
         
         // calculate acres
         acres = (int) sqin / 6272640;
         sqin %= 6272640;
         System.out.println("\tAcres: " + acres);
         
         // calculate square yards
         sqyards = (int) sqin / 1296;
         sqin %= 1296;
         System.out.println("\tSquare Yards: " + sqyards);
         
         // calculate square feet & square inches
         sqfeet = (int) sqin / 144;
         sqin %= 144;
         System.out.println("\tSquare Feet: " + sqfeet);
         System.out.println("\tSquare Inches: " + sqin);
      
      }
   
   }
}