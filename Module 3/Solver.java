import java.util.Scanner;
import java.text.DecimalFormat;

/** Finding the Solvern program.
* Project 3
* @author Nicole Mills - CSPC 1210 - Summer
* @version 06.09.21
*/
public class Solver {
   /**
* Compute user input and print results.
* @param args Command line arguments - not used.
*/
   public static void main(String[] args) {
      double x = 0;
      double result = 0;
      int charLeft = 0;
      int charRight = 0;
      Scanner userInput = new Scanner(System.in);
      String numbers = "";
      int index = 0;
      String charL = "";
      String charR = "";
      
      // user input value x
      System.out.print("Enter a value for x: ");
      x = userInput.nextDouble();
      
      // compute result
      result = (Math.sqrt(Math.abs(11 * Math.pow(x, 4)) + (9 * Math.pow(x, 3))
           + (7 * Math.pow(x, 2)) + ((5 * x) + 4)))
           / ((2 * x) + 4);
         
      // print result
      System.out.println("Result: " + result);
      
      
      // find decimal point
      numbers = Double.toString(result);
      index = numbers.indexOf('.');
      
      // compute decimal point places
      charL = numbers.substring(0, index);
      charR = numbers.substring(index + 1);
      charLeft = charL.length();
      charRight = charR.length();
      
      // formate decimal format
      DecimalFormat df = new DecimalFormat("#,##0.0####");
      
      // print # left and right of dec point
      System.out.println("# of characters to left of decimal point: " 
           + charLeft);
         
      System.out.println("# of characters to right of decimal point: "
           + charRight);
      
      // formatted result
      System.out.println("Formatted Result: " + df.format(result));
        
   }
}