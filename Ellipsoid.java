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
// instance variable
   private String label = "";
   private double a = 0;
   private double b = 0;
   private double c = 0;

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
      } else {
         label = labelIn.trim();
         return true;
      }
   }

   /**
    * Methods.
    * @return getA
    */
   public double getA() {
      return a;
   }

   /**
    * Methods.
    * @param aIn this returms a boolean.
    * @return setA
    */
   public boolean setA(double aIn) {
      if (aIn > 0) {
         a = aIn;
         return true;
      } else {
         return false;
      }
   }

   /**
    * Methods.
    * @return getB
    */
   public double getB() {
      return b;
   }

   /**
    * Methods.
    * @param bIn this returms a boolean.
    * @return setB
    */
   public boolean setB(double bIn) {
      if (bIn > 0) {
         b = bIn;
         return true;
      } else {
         return false;
      }
   }

   /**
    * Methods.
    * @return getC
    */
   public double getC() {
      return c;
   }

   /**
    * Methods.
    * @param cIn this returna a boolean.
    * @return setC
    */
   public boolean setC(double cIn) {
      if (cIn > 0) {
         c = cIn;
         return true;
      } else {
         return false;
      }
   }

   /**
    * Methods.
    * @return volume
    */
   public double volume() {
      double volume = ((4 * Math.PI * a * b * c) / 3);
      return volume;
   }

   /**
    * Methods.
    * @return surfaceArea
    */
   public double surfaceArea() {
      double thePowers = (Math.pow((a * b), 1.6) 
         + Math.pow((a * c), 1.6) + Math.pow((b * c), 1.6)) / 3;
      double surfaceArea = 4 * Math.PI * Math.pow(thePowers, (1.0 / 1.6));
      return surfaceArea;
   }

   /**
    * Methods.
    * @return toString
    */
   public String toString() {
      DecimalFormat decimalFormat = new DecimalFormat("#,##0.0###");
      return "Ellipsoid \"" + getLabel() + "\" with axes a = " 
         + decimalFormat.format(a) + ", b = "
         + decimalFormat.format(b) + ", c = " 
         + decimalFormat.format(c) + " units has:\n\tvolume = "
         + decimalFormat.format(volume()) 
         + " cubic units" + "\n\tsurface area = "
         + decimalFormat.format(surfaceArea()) + " square units";
   }
}