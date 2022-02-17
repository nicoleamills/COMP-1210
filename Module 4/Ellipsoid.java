import java.text.DecimalFormat;

/** 
* Ellipsoid class that stores methods and calculates
* the volume and surface area of the object.
* Project 04.
* @author Nicole Mills - CSPC 1210 - Summer.
* @version 06.19.20
*/

public class Ellipsoid {

/** 
* Project Description.
*/ 

// instance variables
   private String label = "";
   private double a = 0.0;
   private double b = 0.0;
   private double c = 0.0;
   

/**
   * Constructor.
   * @param labelIn for label name
   * @param aIn for a input
   * @param bIn for b input
   * @param cIn for c input
   */  
   public Ellipsoid(String labelIn, double aIn, double bIn, double cIn) {
      setLabel(labelIn);
      setA(aIn);
      setB(bIn);
      setC(cIn);
   }
 
   /**
   * Methods.
   * @return label field
   */  
   public String getLabel() {
      return label;
   }
   
   /**
   * Methods.
   * @param labelIn for user input string
   * @return trimmed String
   */ 
   public boolean setLabel(String labelIn) {
      if (labelIn == null) {
         return false;
      }
      else {
         label = labelIn.trim();
         return true;
      }
   }
   
   /**
   * Methods.
   * @return a input
   */ 
   public double getA() {
      return a;
   }
   
   /**
   * Methods.
   * @param aIn for user input
   * @return if a greater than 0, return true
   */ 
   public boolean setA(double aIn) {
      if (aIn > 0) {
         a = aIn;
         return true;
      }
      else {
         return false;
      }   
   }
   
   /**
   * Methods.
   * @return b input
   */ 
   public double getB() {
      return b;
   }
   
   /**
   * Methods.
   * @param bIn for user input
   * @return if b greater than 0, return true
   */ 
   public boolean setB(double bIn) {
      if (bIn > 0) {
         b = bIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   * Methods.
   * @return c input
   */ 
   public double getC() {
      return c;
   }
   
   /**
   * Methods.
   * @param cIn for user input
   * @return if c greater than 0, return true
   */ 
   public boolean setC(double cIn) {
      if (c > 0) {
         c = cIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   * Methods.
   * @return value for volume formula
   */ 
   public double volume() {
      double volume = ((4 * Math.PI * a * b * c) / 3);
      return volume;
   }
   
   /**
   * Methods.
   * @return value for surface area volume
   */ 
   public double surfaceArea() {
      double sa = (Math.pow((a * b), 1.6)
         + Math.pow((a * c), 1.6)
         + Math.pow((b * c), 1.6)) / 3;
      sa = 4 * Math.PI * Math.pow(sa, (1.0 / 1.6));
      return sa;
   }
   
   /**
   * Methods.
   * @return the ellipsoid and userinput info
   */ 
   public String toStrincng() {
      DecimalFormat df = new DecimalFormat("#,##0.0###");
      return "Ellipsoid \"" + label + "\" " + "with axes a = "
         + a + ", b = " + b + ", c = " + c + " units has: "
         + "\n\tvolume = " + df.format(volume()) + " cubic units"
         + "\n\tsurface area = " + df.format(surfaceArea()) + " square units";
   }
   
   
}

