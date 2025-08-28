/**
 * @description: This class represents a rectangle with length and width
 * @author: Bùi Nguyễn Thanh Phi
 * @version: 1.0
 * @created: 28-Aug-2025 9:38:36 AM
 */

package iuh.fit.cs;

import java.util.Scanner;

public class TestRectangle {
	public static Rectangle input() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap tu ban phim cho canh HCN: ");
	    System.out.print("Enter length: ");
	    double l = sc.nextDouble();
	    System.out.print("Enter width: ");
	    double w = sc.nextDouble();
	    Rectangle h = new Rectangle(l, w);
	    return h;
	}	    
	public static void main(String[] args) throws Exception {
		    Rectangle h1 = new Rectangle(); 
		    h1.setLength(10); 
		    h1.setWidth(3); 
		    h1.inTieuDe(); 
		    System.out.println(h1); 
		    Rectangle h2 = new Rectangle(120, 30); 
		    System.out.println(h2); 
		    System.out.println(input());
		}
}

