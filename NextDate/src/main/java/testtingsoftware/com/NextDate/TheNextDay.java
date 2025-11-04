package testtingsoftware.com.NextDate;

import java.util.Scanner;

public class TheNextDay {
	Scanner sc = new Scanner(System.in);
	private String day;
	private String year;
	private String month;
	public TheNextDay() {
		this.day = "dd";
		this.year = "yyyy";
		this.month = "mm";
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public TheNextDay(String day, String year, String month) {
		this.day = day;
		this.year = year;
		this.month = month;
	}
	public boolean characterDay() {
		if(day.length() <= 2 && day.length() > 0) {
			for(int i = 0; i < day.length(); i++) {
				char c = day.charAt(i); // lấy từng ký tự
				if(!Character.isDigit(c)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public boolean characterMonth() {
		if(month.length() <= 2 && month.length() > 0) {
			for(int i = 0; i < month.length(); i++) {
				char c = month.charAt(i); // lấy từng ký tự
				if(!Character.isDigit(c)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public boolean characterYear() {
		if(year.length() <= 4 && year.length() > 0) {
			for(int i = 0; i < year.length(); i++) {
				char c = year.charAt(i); // lấy từng ký tự
				if(!Character.isDigit(c)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public boolean checkLogic() {
		if(characterDay() && characterMonth() && characterYear()) {
			int numDay = Integer.parseInt(day);
			int numMonth = Integer.parseInt(month);
				switch (numMonth) {
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
					{
						if(numDay <= 31 && numDay > 0) {
							return true;
						}
						break;
					}
					case 2:{
						if(checkYearleap()) {
							if(numDay <= 29 && numDay > 0) {
								return true;
							}
						}
						else {
							if(numDay <= 28 && numDay > 0) {
								return true;
							}
						}
						break;
					}
					case 4:
					case 6:
					case 9:
					case 11:{
						if(numDay <= 30 && numDay > 0) {
							return true;
						}
						break;
					}
				default:
					System.out.println("Thang khong hop le:");
					return false;
			}
		}
		return false;
	}
	public boolean checkYearleap() {
		if(characterYear()) {
			int numYear = Integer.parseInt(year);
			boolean isLeap = (numYear % 4 == 0 && numYear % 100 != 0) || (numYear % 400 == 0);
			if(isLeap) {
				System.out.println("Nam " +  numYear + " la nam nhuan");
			}
			else {
				System.out.println("Nam " +  numYear + " la nam khong nhuan");
			}
			return isLeap;
		}
		return false;
	}
	public void input() {
		 do {
		        System.out.print("Nhap ngay: ");
		        day = sc.next();
		        System.out.print("Nhap thang: ");
		        month = sc.next();
		        System.out.print("Nhap nam: ");
		        year = sc.next();
		        if (!checkLogic()) {
		            System.out.println("Ngay thang nam khong hop le. Moi nhap lai!");
		        }
		    } while (!checkLogic());
	}
	public void output() {
		int numDay = Integer.parseInt(day);
	    int numMonth = Integer.parseInt(month);
	    int numYear = Integer.parseInt(year);

	    int maxDay = 1;
	    switch (numMonth) {
		    case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: {
				maxDay = 31;
			}
			case 4:
			case 6:
			case 9:
			case 11:{
				maxDay = 30;
			}
			case 2:{
				if(checkYearleap()) {
					maxDay = 29;
				}
				else {
					maxDay = 28;
				}
			}

		default:
			break;
		}
	    numDay++;
	    if (numDay > maxDay) {
	        numDay = 1;
	        numMonth++;
	        if (numMonth > 12) {
	            numMonth = 1;
	            numYear++;
	        }
	    }
		System.out.println("Ngay ban nhap la: " + "ngay " + day + " thang " + month + " nam " + year );
		System.out.println("Ngay ke tiep la: " + "ngay " + numDay + " thang " + numMonth + " nam " + numYear );
	}
	public static void main(String[] args) {
		TheNextDay nd = new TheNextDay();
		nd.input();
		nd.output();
	}
}
