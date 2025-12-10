package nextdate;

public class NextDateBuggy {
    
    public static String getNextDate(int day, int month, int year) {
        if (month < 1 || month > 12) {
            return "INVALID";
        }
        
        if (day < 1) {
            return "INVALID";
        }
        
        int[] daysInMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (day > daysInMonth[month - 1]) {
            return "INVALID";
        }
        
        if (day == daysInMonth[month - 1]) {
            if (month == 12) {
                return "1/1/" + (year + 1);
            } else {
                return "1/" + (month + 1) + "/" + year;
            }
        }
        
        return (day + 1) + "/" + month + "/" + year;
    }
}
