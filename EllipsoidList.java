import java.util.ArrayList;
import java.text.DecimalFormat;
/** 
* Creates EllipsoidList class and returns summary info.
* Project 05.
* @author Nicole Mills - CSPC 1210 - Summer.
* @version 06.26.21
*/

public class EllipsoidList {

// instance variables
   private String listName = "";
   private ArrayList<Ellipsoid> ellipObj = new ArrayList<Ellipsoid>();

// constructor
/**
* Creating an EllipsoidList object.
* @param listNameIn for list name
* @param ellipObjIn for ellipsoid list
*/
   public EllipsoidList(String listNameIn, ArrayList<Ellipsoid> ellipObjIn) {
      listName = listNameIn;
      ellipObj = ellipObjIn;
   }
   
// methods
/**
* Methods.
* @return the list name
*/
   public String getName() {
      return listName;
   }
   
/**
* Methods.
* @return the number of ellipsoids
*/
   public int numberOfEllipsoids() {
      int numberOfEllipsoids = 0;
      if (ellipObj.size() == 0) {
         return 0;
      }
      else {
         return ellipObj.size();
      }
   }
   
/**
* Methods.
* @return the total volume
*/
   public double totalVolume() {
      double total = 0;
      int index = 0;
      while (index < ellipObj.size()) {
         total += (ellipObj.get(index).volume());
         index++;
      }
      return total;
   }
    
/**
* Methods.
* @return the total surface area
*/  
   public double totalSurfaceArea() {
      int index = 0;
      double listTotalSurfaceArea = 0;
      while (index < ellipObj.size()) {
         listTotalSurfaceArea += ellipObj.get(index).surfaceArea();
         index++;
      }
      return listTotalSurfaceArea;
   } 
   
/**
* Methods.
* @return the average volume
*/
   public double averageVolume() {
      double total = 0;
      int index = 0;
      while (index < ellipObj.size()) {
         total += ellipObj.get(index).volume();
         index++;
      }
      if (index == 0) {
         total = 0;
      }
      else {
         total = total / index;
      }
      return total;
   }
   
/**
* Methods.
* @return the average surface area
*/
   public double averageSurfaceArea() {
      double total = 0;
      int index = 0;
      while (index < ellipObj.size()) {
         total += ellipObj.get(index).surfaceArea();
         index++;
      }
      if (index == 0) {
         total = 0;
      }
      else {
         total = total / index;
      }
      return total;
   }
   
/**
* Methods.
* @return the string result
*/
   public String toString() {
      String result = getName() + "\n";
      int index = 0;
      while (index < ellipObj.size()) {
         result += "\n" + ellipObj.get(index) + "\n";
         index++;
      }
      return result;
   }
   
/**
* Methods.
* @return the string's summary info
*/
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.###");
      String result = "";
      result += "\n";
      result += "---- Summary for " + getName() + "----";
      result += "\nNumber of Ellipsoid Objects: " + numberOfEllipsoids();
      result += "\nTotal Volume: " + df.format(totalVolume()) + " cubic units";
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea()) + " square units";
      result += "\nAverage Volume: " + df.format(averageVolume()) + " cubic units";
      result += "\nAverage Surface Area: " + df.format(averageSurfaceArea()) 
         + " square units";
      return result;
   }
   
   public ArrayList<Ellipsoid> getList() {
      return ellipObj;
   }
   
}