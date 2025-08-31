/**
 * @description: This class represents a rectangle with length and width
 * @author: Bui Nguyen Thanh Phi
 * @version: 1.0
 * @created: 28-Aug-2025 9:38:36 AM
 */

package iuh.fit.cs;

public class Rectangle {
    private double length;
    private double width;
    
    public void setLength(double l) throws Exception {
       if(l > 0) {
          this.length = l;
       }
       else throw new Exception("Loi l");
    }
    
    public void setWidth(double w) throws Exception {
       if(w > 0) {
          this.width = w;
       }
       else throw new Exception("Loi w");
    }
    
    public double getLength() {
       return this.length;
    }
    
    public double getWidth() {
       return this.width;
    }
    
    public Rectangle() {}
    public Rectangle(double l, double w) throws Exception {
       if(l > 0) {
          this.length = l;
       }else throw new Exception("Loi l");
       if(w > 0) {
          this.width = w;
       }else throw new Exception("Loi w");
    }
    
    public double getPerimeter() {
       return (getLength() + getWidth()) * 2; 
    }
    
    public double getArea(double l, double w) {
       return l * w;
    }
    
    public static void inTieuDe() {
       System.out.println("Perimeter and area rectangle: ");
       for(int i = 0; i < 45; i++) {
          System.out.printf("-");
       }
       System.out.println();
       String s = "";
       s = s + String.format("|%-10s|%-10s|%-10s|%-10s|", "Length", "Width", "Perimeter", "Area");
       System.out.println(s);
       for(int i = 0; i < 45; i++) {
          System.out.printf("-");
       }
       System.out.println();
    }
    
    public String toString() {
       String s = "";
       s = s + String.format("|%-10s|%-10s|%-10s|%-10s|", getLength(), getWidth(), getPerimeter(), getArea(length, width));
       return s;
    }
    
    public static void main(String[] args) {
       inTieuDe();
    }
}
