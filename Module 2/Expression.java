/** Finding the expression program.
* Project 2
* @author Nicole Mills - CSPC 1210 - Summer
* @version 06.02.21
*/

import java.util.Scanner;

/** Simple program that uses the Scanner class
* to solve an expression.
*/

public class Expression {

/**
* Create a scanner class to evaluate an expression
* with user input.
* @param args Command line arguments - not used.
*/
   
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      double result = 0.0;
      System.out.println("result = (10x + 32.6) (5y - 1.567) / xy");
      System.out.print("\tx = ");
      double x = scan.nextDouble();
      
      System.out.print("\ty = ");
      double y = scan.nextDouble();
      
      if (x == 0 || y == 0) {
         System.out.println("result is \"undefined\"");
      }
      
      else {
         result = (10 * x + 32.6) * (5 * y - 1.567) / (x * y);
         System.out.println("result = " + result);
      }
   
   }
}