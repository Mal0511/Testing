package testtingsoftware.com.Triangle;

import java.util.Scanner;

public class Triangle {
	private Scanner sc = new Scanner(System.in);
	private double a;
	private double b;
	private double c;
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
		System.out.println("Nhap canh a:");
		a = sc.nextFloat();
		System.out.println("Nhap canh b:");
		b = sc.nextFloat();
		System.out.println("Nhap canh c:");
		c = sc.nextFloat();
	}
	public boolean CheckTriangle() {
		if(a <= 0 || b <= 0 || c <= 0) {
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
	public void CheckTriangleType() {
		if(CheckTriangle()) {
			if(a == b && a == c) {
				System.out.print("Deu");
			}
			else {
				double max = Math.max(a, Math.max(b, c));
				double sumSq = a * a + b * b + c * c - max * max;
				boolean iscan = (a == b || a == c || c == b);
				boolean isvuong = sumSq == max * max; 
				if(iscan && isvuong) {
					System.out.print("Vuong can");
				}
				else {
					if(iscan) {
						System.out.print("can");
					}
					else {
						if(isvuong) {
							System.out.print("Vuong");
						}
						else {
							if(sumSq > max * max) {
								System.out.print("Nhon");
							}
							else {
								System.out.print("Tu");
							}
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Triangle tamgiac = new Triangle();
		tamgiac.input();
		tamgiac.CheckTriangleType();
	}
}
