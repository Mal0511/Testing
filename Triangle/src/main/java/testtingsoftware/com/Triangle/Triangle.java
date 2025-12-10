package testtingsoftware.com.Triangle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle {
	private Scanner sc = new Scanner(System.in);
	private double a;
	private double b;
	private double c;
	private boolean inputValid = false;
	public Triangle() {
		this.a = 0;
		this.b = 0;
		this.c = 0;
	}
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	public void input() {
		while (!inputValid) {
	        try {
	            System.out.print("Nhap canh a: ");
	            a = sc.nextDouble();
	            if (!isValidCanh(a)) {
	                System.out.println("Canh a phai trong khoang 1-200");
	                continue;
	            }

	            System.out.print("Nhap canh b: ");
	            b = sc.nextDouble();
	            if (!isValidCanh(b)) {
	                System.out.println("Canh b phai trong khoang 1-200");
	                continue;
	            }

	            System.out.print("Nhap canh c: ");
	            c = sc.nextDouble();
	            if (!isValidCanh(c)) {
	                System.out.println("Canh c phai trong khoang 1-200");
	                continue;
	            }

	            break;
	        } catch (InputMismatchException e) {
	            System.out.println("Gia tri nhap phai la so!");
	            sc.nextLine();
	        }
	    }
	
	}
	private boolean isValidCanh(double canh) {
	    if(canh > 200 || canh <= 0) {
	    	return false;
	    }
	    return true;
	}
	public boolean CheckTriangle() {
		if (!isValidCanh(a) || !isValidCanh(b) || !isValidCanh(c)) {
		    System.out.println("Canh phai trong khoang 1–200");
		    return false;
		}
		else {
			if(a + b > c  && a + c > b  && c + b > a) {
				System.out.print("Ba canh a, b, c tao thanh mot tam giac ");
				return true;
			}
			else {
				System.out.println("Ba canh a, b, c khong tao thanh mot tam giac");
				return false;
			}
		}
	}
	public String CheckTriangleType() {
		if (!CheckTriangle()) {
	        return "Invalid";
	    }
	    if (a == b && b == c) {
	        return "Deu";
	    }
	    double max = Math.max(a, Math.max(b, c));
	    double sumSq = a * a + b * b + c * c - max * max; 

	    boolean isCan = (a == b || b == c || a == c);
	    boolean isVuong = Math.abs(sumSq - max * max) < 1e-6;
	    
	    if (isCan && isVuong) {
	        return "Vuong can";
	    }


	    if (isCan) {
	        return "Can";
	    }

	    if (isVuong) {
	        return "Vuong";
	    }

	    if (sumSq > max * max) {
	        return "Nhon";
	    }

	    return "Tu";

	}
	public static void main(String[] args) {
		Triangle tamgiac = new Triangle();
		tamgiac.input();
		System.out.println(tamgiac.CheckTriangleType());
	}
}
