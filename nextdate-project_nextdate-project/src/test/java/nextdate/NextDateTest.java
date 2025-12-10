package nextdate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

public class NextDateTest {
    
    @BeforeEach
    void setUp() {
        System.out.println("Starting test...");
    }
    
    @AfterEach
    void tearDown() {
        System.out.println("Test completed.");
    }
    
    // BVA Tests
    @Test
    @DisplayName("TC-NEXT-01: Ngày cuối tháng 1")
    void testEndOfJanuary() {
        assertEquals("1/2/2023", NextDate.getNextDate(31, 1, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-02: Ngày cuối tháng 2 không nhuận")
    void testEndOfFebruaryNonLeap() {
        assertEquals("1/3/2023", NextDate.getNextDate(28, 2, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-03: Ngày 29/2 không nhuận")
    void testFebruary29NonLeap() {
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-04: Ngày 32/1")
    void testInvalidDay32() {
        assertEquals("INVALID", NextDate.getNextDate(32, 1, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-05: Ngày 0/5")
    void testInvalidDay0() {
        assertEquals("INVALID", NextDate.getNextDate(0, 5, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-06: Tháng 0")
    void testInvalidMonth0() {
        assertEquals("INVALID", NextDate.getNextDate(15, 0, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-07: Tháng 13")
    void testInvalidMonth13() {
        assertEquals("INVALID", NextDate.getNextDate(15, 13, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-08: Ngày 31/4")
    void testInvalidApril31() {
        assertEquals("INVALID", NextDate.getNextDate(31, 4, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-09: Ngày 31/6")
    void testInvalidJune31() {
        assertEquals("INVALID", NextDate.getNextDate(31, 6, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-10: Ngày 31/9")
    void testInvalidSeptember31() {
        assertEquals("INVALID", NextDate.getNextDate(31, 9, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-11: Ngày 31/11")
    void testInvalidNovember31() {
        assertEquals("INVALID", NextDate.getNextDate(31, 11, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-12: Ngày 30/2")
    void testInvalidFebruary30() {
        assertEquals("INVALID", NextDate.getNextDate(30, 2, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-13: Ngày 28/2 năm nhuận")
    void testFebruary28LeapYear() {
        assertEquals("29/2/2024", NextDate.getNextDate(28, 2, 2024));
    }
    
    @Test
    @DisplayName("TC-NEXT-14: Ngày 29/2 năm nhuận")
    void testFebruary29LeapYear() {
        assertEquals("1/3/2024", NextDate.getNextDate(29, 2, 2024));
    }
    
    @Test
    @DisplayName("TC-NEXT-15: Ngày 30/4")
    void testApril30() {
        assertEquals("1/5/2023", NextDate.getNextDate(30, 4, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-16: Ngày cuối năm")
    void testEndOfYear() {
        assertEquals("1/1/2024", NextDate.getNextDate(31, 12, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-17: Ngày 15/6")
    void testJune15() {
        assertEquals("16/6/2023", NextDate.getNextDate(15, 6, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-18: Ngày 1/3")
    void testMarch1() {
        assertEquals("2/3/2023", NextDate.getNextDate(1, 3, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-19: Ngày 30/6")
    void testJune30() {
        assertEquals("1/7/2023", NextDate.getNextDate(30, 6, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-20: Ngày 31/8")
    void testAugust31() {
        assertEquals("1/9/2023", NextDate.getNextDate(31, 8, 2023));
    }
    
    // BCP Tests
    @Test
    @DisplayName("TC-NEXT-21: Năm 1811")
    void testYear1811() {
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 1811));
    }
    
    @Test
    @DisplayName("TC-NEXT-22: Năm 2025")
    void testYear2025() {
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 2025));
    }
    
    @Test
    @DisplayName("TC-NEXT-23: Ngày âm")
    void testNegativeDay() {
        assertEquals("INVALID", NextDate.getNextDate(-1, 5, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-24: Tháng âm")
    void testNegativeMonth() {
        assertEquals("INVALID", NextDate.getNextDate(10, -1, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-25: Năm âm")
    void testNegativeYear() {
        assertEquals("INVALID", NextDate.getNextDate(10, 5, -1));
    }
    
    @Test
    @DisplayName("TC-NEXT-26: Năm 0")
    void testYear0() {
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 0));
    }
    
    @Test
    @DisplayName("TC-NEXT-27: Năm 3000")
    void testYear3000() {
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 3000));
    }
    
    @Test
    @DisplayName("TC-NEXT-28: Ngày 1/1/1812")
    void testMinValidDate() {
        assertEquals("2/1/1812", NextDate.getNextDate(1, 1, 1812));
    }
    
    @Test
    @DisplayName("TC-NEXT-29: Ngày 31/12/2024")
    void testMaxValidDate() {
        assertEquals("1/1/2025", NextDate.getNextDate(31, 12, 2024));
    }
    
    @Test
    @DisplayName("TC-NEXT-30: Năm 1900 không nhuận")
    void testYear1900NotLeap() {
        assertEquals("1/3/1900", NextDate.getNextDate(28, 2, 1900));
    }
    
    @Test
    @DisplayName("TC-NEXT-31: Ngày 29/2/1900")
    void testFebruary29Year1900() {
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 1900));
    }
    
    @Test
    @DisplayName("TC-NEXT-32: Năm 2000 nhuận")
    void testYear2000Leap() {
        assertEquals("29/2/2000", NextDate.getNextDate(28, 2, 2000));
    }
    
    @Test
    @DisplayName("TC-NEXT-33: Ngày 29/2/2000")
    void testFebruary29Year2000() {
        assertEquals("1/3/2000", NextDate.getNextDate(29, 2, 2000));
    }
    
    @Test
    @DisplayName("TC-NEXT-34: Ngày 28/2/2024")
    void testFebruary28_2024() {
        assertEquals("29/2/2024", NextDate.getNextDate(28, 2, 2024));
    }
    
    @Test
    @DisplayName("TC-NEXT-35: Ngày 29/2/2024")
    void testFebruary29_2024() {
        assertEquals("1/3/2024", NextDate.getNextDate(29, 2, 2024));
    }
    
    @Test
    @DisplayName("TC-NEXT-36: Tháng 3 ngày 31")
    void testMarch31() {
        assertEquals("1/4/2023", NextDate.getNextDate(31, 3, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-37: Tháng 5 ngày 31")
    void testMay31() {
        assertEquals("1/6/2023", NextDate.getNextDate(31, 5, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-38: Tháng 7 ngày 31")
    void testJuly31() {
        assertEquals("1/8/2023", NextDate.getNextDate(31, 7, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-39: Tháng 8 ngày 31")
    void testAugust31_2() {
        assertEquals("1/9/2023", NextDate.getNextDate(31, 8, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-40: Tháng 10 ngày 31")
    void testOctober31() {
        assertEquals("1/11/2023", NextDate.getNextDate(31, 10, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-41: Tháng 10 ngày 30")
    void testOctober30() {
        assertEquals("31/10/2023", NextDate.getNextDate(30, 10, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-42: Tháng 4 ngày 30")
    void testApril30_2() {
        assertEquals("1/5/2023", NextDate.getNextDate(30, 4, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-43: Tháng 6 ngày 30")
    void testJune30_2() {
        assertEquals("1/7/2023", NextDate.getNextDate(30, 6, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-44: Tháng 9 ngày 30")
    void testSeptember30() {
        assertEquals("1/10/2023", NextDate.getNextDate(30, 9, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-45: Tháng 11 ngày 30")
    void testNovember30() {
        assertEquals("1/12/2023", NextDate.getNextDate(30, 11, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-46: Ngày 31/2")
    void testInvalidFebruary31() {
        assertEquals("INVALID", NextDate.getNextDate(31, 2, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-47: Ngày 32/3")
    void testInvalidMarch32() {
        assertEquals("INVALID", NextDate.getNextDate(32, 3, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-48: Ngày 31/4")
    void testInvalidApril31_2() {
        assertEquals("INVALID", NextDate.getNextDate(31, 4, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-49: Ngày 31/6")
    void testInvalidJune31_2() {
        assertEquals("INVALID", NextDate.getNextDate(31, 6, 2023));
    }
    
    @Test
    @DisplayName("TC-NEXT-50: Ngày 31/9")
    void testInvalidSeptember31_2() {
        assertEquals("INVALID", NextDate.getNextDate(31, 9, 2023));
    }
    
    @Nested
    @DisplayName("Additional Tests")
    class AdditionalTests {
        @Test
        @DisplayName("Test ngày thường")
        void testRegularDay() {
            assertEquals("16/6/2023", NextDate.getNextDate(15, 6, 2023));
        }
        
        @Test
        @DisplayName("Test chuyển tháng 30 ngày")
        void test30DayMonthEnd() {
            assertEquals("1/5/2023", NextDate.getNextDate(30, 4, 2023));
        }
        
        @Test
        @DisplayName("Test năm nhuận đặc biệt")
        void testSpecialLeapYears() {
            assertEquals("29/2/2024", NextDate.getNextDate(28, 2, 2024));
            assertEquals("29/2/2000", NextDate.getNextDate(28, 2, 2000));
            assertEquals("1/3/2100", NextDate.getNextDate(28, 2, 2100));
        }
    }
}
