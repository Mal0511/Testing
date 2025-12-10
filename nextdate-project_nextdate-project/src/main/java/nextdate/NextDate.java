package nextdate;

public class NextDate {
    
    public static String getNextDate(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            return "INVALID";
        }
        
        if (isEndOfMonth(day, month, year)) {
            if (month == 12) {
                return "1/1/" + (year + 1);
            } else {
                return "1/" + (month + 1) + "/" + year;
            }
        }
        
        return (day + 1) + "/" + month + "/" + year;
    }
    
    private static boolean isValidDate(int day, int month, int year) {
        if (year < 1812 || year > 2024) {
            return false;
        }
        
        if (month < 1 || month > 12) {
            return false;
        }
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        
        if (day < 1 || day > daysInMonth[month - 1]) {
            return false;
        }
        
        return true;
    }
    
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    
    private static boolean isEndOfMonth(int day, int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        
        return day == daysInMonth[month - 1];
    }
    
    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }
        
        return daysInMonth[month - 1];
    }
}
