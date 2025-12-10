package nextdate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class NextDateBuggyTest {
    
    @Test
    @DisplayName("BUG: Ngày 29/2/2023 không nhuận")
    void testBugFebruary29NonLeap() {
        assertNotEquals("INVALID", NextDateBuggy.getNextDate(29, 2, 2023),
            "BUG: Hàm buggy không validate năm nhuận đúng");
    }
    
    @Test
    @DisplayName("BUG: Ngày 31/4")
    void testBugApril31() {
        assertNotEquals("INVALID", NextDateBuggy.getNextDate(31, 4, 2023),
            "BUG: Hàm buggy không validate số ngày trong tháng");
    }
    
    @Test
    @DisplayName("BUG: Năm 1811")
    void testBugYear1811() {
        assertNotEquals("INVALID", NextDateBuggy.getNextDate(1, 1, 1811),
            "BUG: Hàm buggy không validate khoảng năm");
    }
    
    @Test
    @DisplayName("BUG: Ngày 31/2")
    void testBugFebruary31() {
        assertNotEquals("INVALID", NextDateBuggy.getNextDate(31, 2, 2023),
            "BUG: Hàm buggy không validate ngày trong tháng 2");
    }
    
    @Test
    @DisplayName("BUG: Năm 1900 không nhuận, ngày 29/2")
    void testBugYear1900February29() {
        assertNotEquals("INVALID", NextDateBuggy.getNextDate(29, 2, 1900),
            "BUG: Hàm buggy không xử lý đúng năm 1900");
    }
    
    @Test
    @DisplayName("Ngày thường vẫn đúng")
    void testRegularDayBuggy() {
        assertEquals("16/6/2023", NextDateBuggy.getNextDate(15, 6, 2023));
    }
    
    @Test
    @DisplayName("Ngày cuối tháng 1 vẫn đúng")
    void testEndOfJanuaryBuggy() {
        assertEquals("1/2/2023", NextDateBuggy.getNextDate(31, 1, 2023));
    }
}
