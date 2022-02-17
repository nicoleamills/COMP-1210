import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;
/** 
* Creates EllipsoidList class and returns summary info.
* Project 05.
* @author Nicole Mills - CSPC 1210 - Summer.
* @version 06.26.21
*/

public class EllipsoidList {

// instance variables
   private String listName = "";
   private ArrayList<Ellipsoid> eList = new ArrayList<Ellipsoid>();

// constructor
/**
* Creating an EllipsoidList object.
* @param listNameIn for list name
* @param eListIn for ellipsoid list
*/
   public EllipsoidList(String listNameIn, ArrayList<Ellipsoid> eListIn) {
      listName = listNameIn;
      eList = eListIn;
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
      if (eList.size() == 0) {
         return 0;
      }
      else {
         return eList.size();
      }
   }
   
/**
* Methods.
* @return the total volume
*/
   public double totalVolume() {
      double total = 0;
      int index = 0;
      while (index < eList.size()) {
         total += (eList.get(index).volume());
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
      while (index < eList.size()) {
         listTotalSurfaceArea += eList.get(index).surfaceArea();
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
      while (index < eList.size()) {
         total += eList.get(index).volume();
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
      while (index < eList.size()) {
         total += eList.get(index).surfaceArea();
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
      while (index < eList.size()) {
         result += "\n" + eList.get(index) + "\n";
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
      result += "\n----- Summary for " + getName() + " -----";
      result += "\nNumber of Ellipsoid Objects: " + numberOfEllipsoids();
      result += "\nTotal Volume: " + df.format(totalVolume()) + " cubic units";
      result += "\nTotal Surface Area: " + df.format(totalSurfaceArea()) 
         + " square units";
      result += "\nAverage Volume: " 
         + df.format(averageVolume()) + " cubic units";
      result += "\nAverage Surface Area: " 
         + df.format(averageSurfaceArea()) 
         + " square units";
      return result;
   }
   
   /**
   * Methods.
   * @return eList for ellipsoid
   */
   public ArrayList<Ellipsoid> getList() {
      return eList;
   }
   
   /**
   * description.
   * @param eFileNameIn for file name to read
   * @return eL Ellipsoid list
   * @throws FileNotFoundException if file can't be opened
   */
   public static EllipsoidList readFile(String eFileNameIn) 
      throws FileNotFoundException {
      try {
         Scanner fileScan = new Scanner(new File(eFileNameIn));
      
         ArrayList<Ellipsoid> newEList = new ArrayList<Ellipsoid>();
         String eListName = "";
      
         String listName = fileScan.nextLine();
      
         while (fileScan.hasNext()) {
            String label = fileScan.nextLine();
            double a = Double.parseDouble(fileScan.nextLine());
            double b = Double.parseDouble(fileScan.nextLine());
            double c = Double.parseDouble(fileScan.nextLine());
            Ellipsoid e = new Ellipsoid(label, a, b, c);
            newEList.add(e);
         }
      
         EllipsoidList eL = new EllipsoidList(listName, newEList);
         return eL;
      
      }
      catch (FileNotFoundException e) {
         System.out.println("Error- File not found.");
      }
      return null;
   
   }
   
   /**
   * adds ellip object to ellipsoidlist object.
   * @param sLabelIn for label
   * @param dAIn for a input
   * @param dBIn for b input
   * @param dCIn for c input
   */
   public void addEllipsoid(String sLabelIn, double dAIn, 
      double dBIn, double dCIn) {
      Ellipsoid e = new Ellipsoid(sLabelIn, dAIn, dBIn, dCIn);
      eList.add(e);
   }
   
   /**
   * searches ellipsoid.
   * @param sLabelIn for label
   * @return result for ellipsoid obj
   */
   public Ellipsoid findEllipsoid(String sLabelIn) {
      Ellipsoid result = null;
      for (int i = 0; i < eList.size(); i++) {
         if (eList.get(i).getLabel().equalsIgnoreCase(sLabelIn)) {
            result = eList.get(i);
            break;
         }
      }
      return result;
   }
   
   /**
   * description.
   * @param sLabelIn for label
   * @return result for ellipsoid obj
   */
   public Ellipsoid deleteEllipsoid(String sLabelIn) {
      Ellipsoid result = findEllipsoid(sLabelIn);
      if (result != null) {
         eList.remove(result);
      }
      return result;
   }
   
    /**
   * description.
   * @param sLIn for label
   * @param ddAIn for a input
   * @param ddBIn for b input
   * @param ddCIn for c input
   * @return result for ellipsoid obj
   */
   public Ellipsoid editEllipsoid(String sLIn, double ddAIn, 
      double ddBIn, double ddCIn) {
      Ellipsoid e = findEllipsoid(sLIn);
      if (e != null) {
         e.setA(ddAIn);
         e.setB(ddBIn);
         e.setC(ddCIn);
          
      }
      return e;
   }
   
}