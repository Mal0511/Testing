package nextdate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * KIỂM THỬ TỔ HỢP (COMBINATORIAL TESTING)
 * 
 * Sử dụng kết hợp các tham số:
 * - Day: 0, 1, 15, 28, 29, 30, 31, 32
 * - Month: 0, 1, 2, 4, 6, 7, 12, 13  
 * - Year: 0, 1900, 2000, 2023, 2024, 2025, 2100
 * 
 * Pairwise testing: Mọi cặp giá trị được test ít nhất 1 lần
 */
public class NextDateCombinatorialTest {
    
    // Pairwise test cases (generated from PICT model)
    @ParameterizedTest(name = "Combinatorial Test {index}: {0}/{1}/{2} => {3}")
    @CsvSource({
        // Test cases covering all pairwise combinations
        "0, 0, 0, INVALID",
        "1, 0, 0, INVALID",
        "15, 1, 0, INVALID",
        "28, 2, 1900, 1/3/1900",
        "29, 4, 2000, 30/4/2000",
        "30, 6, 2023, 1/7/2023",
        "31, 7, 2024, 1/8/2024",
        "32, 12, 2025, INVALID",
        "1, 13, 2023, INVALID",
        "15, 1, 2100, INVALID",
        "28, 2, 2000, 29/2/2000",
        "29, 2, 2023, INVALID",
        "30, 2, 2024, INVALID",
        "31, 2, 1900, INVALID",
        "31, 4, 2023, INVALID",
        "31, 6, 2024, INVALID",
        "31, 9, 2023, INVALID",
        "31, 11, 2024, INVALID",
        "30, 12, 2023, 31/12/2023",
        "31, 12, 2024, 1/1/2025",
        "1, 1, 1812, 2/1/1812",
        "31, 1, 2024, 1/2/2024",
        "28, 2, 2024, 29/2/2024",
        "29, 2, 2024, 1/3/2024",
        "15, 4, 2023, 16/4/2023",
        "30, 4, 2023, 1/5/2023",
        "15, 6, 2023, 16/6/2023",
        "30, 6, 2023, 1/7/2023",
        "15, 7, 2023, 16/7/2023",
        "31, 7, 2023, 1/8/2023"
    })
    void testPairwiseCombinations(int day, int month, int year, String expected) {
        assertEquals(expected, NextDate.getNextDate(day, month, year),
            String.format("Failed for %d/%d/%d", day, month, year));
    }
    
    // Special combinatorial tests for boundary values
    @Test
    @DisplayName("Combo: Min valid date")
    void testComboMinValidDate() {
        assertEquals("2/1/1812", NextDate.getNextDate(1, 1, 1812));
    }
    
    @Test
    @DisplayName("Combo: Max valid date")
    void testComboMaxValidDate() {
        assertEquals("1/1/2025", NextDate.getNextDate(31, 12, 2024));
    }
    
    @Test
    @DisplayName("Combo: Leap year century divisible by 400")
    void testComboLeapYear400() {
        assertEquals("29/2/2000", NextDate.getNextDate(28, 2, 2000));
        assertEquals("1/3/2000", NextDate.getNextDate(29, 2, 2000));
    }
    
    @Test
    @DisplayName("Combo: Non-leap year century")
    void testComboNonLeapYearCentury() {
        assertEquals("1/3/1900", NextDate.getNextDate(28, 2, 1900));
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 1900));
    }
    
    @Test
    @DisplayName("Combo: 31-day month endings")
    void testCombo31DayMonthEndings() {
        assertEquals("1/2/2023", NextDate.getNextDate(31, 1, 2023));
        assertEquals("1/4/2023", NextDate.getNextDate(31, 3, 2023));
        assertEquals("1/6/2023", NextDate.getNextDate(31, 5, 2023));
        assertEquals("1/8/2023", NextDate.getNextDate(31, 7, 2023));
        assertEquals("1/9/2023", NextDate.getNextDate(31, 8, 2023));
        assertEquals("1/11/2023", NextDate.getNextDate(31, 10, 2023));
        assertEquals("1/1/2024", NextDate.getNextDate(31, 12, 2023));
    }
    
    @Test
    @DisplayName("Combo: 30-day month endings")
    void testCombo30DayMonthEndings() {
        assertEquals("1/5/2023", NextDate.getNextDate(30, 4, 2023));
        assertEquals("1/7/2023", NextDate.getNextDate(30, 6, 2023));
        assertEquals("1/10/2023", NextDate.getNextDate(30, 9, 2023));
        assertEquals("1/12/2023", NextDate.getNextDate(30, 11, 2023));
    }
    
    @Test
    @DisplayName("Combo: Invalid day-month combinations")
    void testComboInvalidDayMonth() {
        // 31 in 30-day months
        assertEquals("INVALID", NextDate.getNextDate(31, 4, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 6, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 9, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 11, 2023));
        
        // 30/31 in February
        assertEquals("INVALID", NextDate.getNextDate(30, 2, 2023));
        assertEquals("INVALID", NextDate.getNextDate(30, 2, 2024));
        assertEquals("INVALID", NextDate.getNextDate(31, 2, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 2, 2024));
    }
    
    // Test tất cả các kết hợp của 29/2 với các loại năm
    @Test
    @DisplayName("Combo: Feb 29 with various years")
    void testComboFeb29VariousYears() {
        // Leap years
        assertEquals("1/3/2024", NextDate.getNextDate(29, 2, 2024));  // ÷4, not ÷100
        assertEquals("1/3/2000", NextDate.getNextDate(29, 2, 2000));  // ÷400
        
        // Non-leap years  
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 2023));  // not ÷4
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 1900));  // ÷100, not ÷400
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 2100));  // ÷100, not ÷400, but year > 2024
    }
    
    // Test độ phủ tổ hợp cao
    @ParameterizedTest(name = "High Coverage Combo {index}: Day={0}, Month={1}")
    @CsvSource({
        "28, 1, 29/1/2023",
        "28, 2, 1/3/2023",
        "28, 2, 29/2/2024",
        "29, 1, 30/1/2023",
        "29, 2, INVALID",
        "29, 2, 1/3/2024",
        "30, 1, 31/1/2023",
        "30, 2, INVALID",
        "30, 4, 1/5/2023",
        "31, 1, 1/2/2023",
        "31, 2, INVALID",
        "31, 3, 1/4/2023",
        "31, 4, INVALID"
    })
    void testHighCoverageCombinations(int day, int month, String expected) {
        int year = (month == 2 && day == 28) ? 2024 : 2023;
        if (expected.contains("2024")) {
            year = 2024;
        }
        assertEquals(expected, NextDate.getNextDate(day, month, year));
    }
}
