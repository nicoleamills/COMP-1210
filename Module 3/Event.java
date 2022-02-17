import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;
/**
 * This program uses user entered info to determine the
 * contents of a ticket to The Lion King.
 *
 * Project 3
 * @author Nicole Mills - CSPC 1210 - Summer
 * @version 06.09.21
 */
public class Event {

   static final double ONE_DISCOUNT = .15;
   static final double TWO_DISCOUNT = .50;
   static final double THREE_DISCOUNT = .75;

/**
 * Project description
 *
 * @param args Command line arguments (not used).
*/
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("$###.00");
      DecimalFormat df2 = new DecimalFormat("$##.##");
      Random generator = new Random();
      String input = "";
   
   // date
      String month = "";
      String day = "";
      String year = "";
   
   // time
      String hour = "";
      String minute = "";
   
      double price = 0.0;
      String discount = "";
      double cost = 0.0;
   
   // seats
      String section = "";
      String seat = "";
      String row = "";
   
      String description = "";
   
   /// compute
      System.out.print("Enter your event code: ");
      input = scan.nextLine().trim();
      System.out.println("");
   
      if (input.length() < 26) {
         System.out.println("Invalid Event Code. "
            + "/nEvent code must have at least 26 characters.");
      }
      
      else {
      //date
         month = input.substring(0, 2);
         day = input.substring(2, 4);
         year = input.substring(4, 8);
         System.out.print("Date: " + month + "/" + day + "/" + year);
         
      // time
         hour = input.substring(8, 10);
         minute = input.substring(10, 12);
         System.out.print(" Time: " + hour + ":" + minute);
      
      
      // seats
         section = input.substring(22, 24);
         row = input.substring(24, 26);
         seat = input.substring(26, 28);
         System.out.print("\nSection: " + section + " Row: " + row + " Seat: " + seat);
      
      // price
         price = Integer.parseInt(input.substring(12, 15)) / 100;
         System.out.print("\nPrice: " + df.format(price));
         
      // discount
         discount = input.substring(17, 19);
         System.out.print(" Discount: " + discount + "%");
         
      // cost
      
      }
   }
}