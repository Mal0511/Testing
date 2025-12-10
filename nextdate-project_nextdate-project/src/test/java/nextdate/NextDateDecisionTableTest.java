package nextdate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 * KIỂM THỬ BẰNG BẢNG QUYẾT ĐỊNH (DECISION TABLE)
 * 
 * Bảng quyết định cho NextDate:
 * 
 * Conditions (Điều kiện):
 * C1: Day trong khoảng 1-27?
 * C2: Day = 28?
 * C3: Day = 29?  
 * C4: Day = 30?
 * C5: Day = 31?
 * C6: Month = 2?
 * C7: Month có 30 ngày? (4,6,9,11)
 * C8: Month có 31 ngày? (1,3,5,7,8,10,12)
 * C9: Năm nhuận?
 * C10: Month = 12?
 * 
 * Actions (Hành động):
 * A1: Day = day + 1
 * A2: Day = 1, Month = month + 1
 * A3: Day = 1, Month = 1, Year = year + 1
 * A4: INVALID
 */
public class NextDateDecisionTableTest {
    
    // Rule 1: Ngày 1-27 (không phải cuối tháng)
    @Test
    @DisplayName("Decision Table Rule 1: Day 1-27, any month")
    void testRule1_Day1To27() {
        assertEquals("16/6/2023", NextDate.getNextDate(15, 6, 2023));
        assertEquals("27/2/2023", NextDate.getNextDate(26, 2, 2023));
        assertEquals("27/2/2024", NextDate.getNextDate(26, 2, 2024));
    }
    
    // Rule 2: Ngày 28, không phải tháng 2
    @Test
    @DisplayName("Decision Table Rule 2: Day 28, not February")
    void testRule2_Day28NotFebruary() {
        assertEquals("29/1/2023", NextDate.getNextDate(28, 1, 2023));
        assertEquals("29/3/2023", NextDate.getNextDate(28, 3, 2023));
    }
    
    // Rule 3: Ngày 28, tháng 2, năm không nhuận
    @Test
    @DisplayName("Decision Table Rule 3: Day 28, Feb, non-leap year")
    void testRule3_Day28FebNonLeap() {
        assertEquals("1/3/2023", NextDate.getNextDate(28, 2, 2023));
    }
    
    // Rule 4: Ngày 28, tháng 2, năm nhuận
    @Test
    @DisplayName("Decision Table Rule 4: Day 28, Feb, leap year")
    void testRule4_Day28FebLeap() {
        assertEquals("29/2/2024", NextDate.getNextDate(28, 2, 2024));
        assertEquals("29/2/2000", NextDate.getNextDate(28, 2, 2000));
    }
    
    // Rule 5: Ngày 29, tháng 2, năm nhuận
    @Test
    @DisplayName("Decision Table Rule 5: Day 29, Feb, leap year")
    void testRule5_Day29FebLeap() {
        assertEquals("1/3/2024", NextDate.getNextDate(29, 2, 2024));
        assertEquals("1/3/2000", NextDate.getNextDate(29, 2, 2000));
    }
    
    // Rule 6: Ngày 29, tháng 2, năm không nhuận → INVALID
    @Test
    @DisplayName("Decision Table Rule 6: Day 29, Feb, non-leap year → INVALID")
    void testRule6_Day29FebNonLeap() {
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 2023));
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 1900));
    }
    
    // Rule 7: Ngày 29, không phải tháng 2
    @Test
    @DisplayName("Decision Table Rule 7: Day 29, not February")
    void testRule7_Day29NotFebruary() {
        assertEquals("30/1/2023", NextDate.getNextDate(29, 1, 2023));
        assertEquals("30/3/2023", NextDate.getNextDate(29, 3, 2023));
    }
    
    // Rule 8: Ngày 30, tháng có 30 ngày
    @Test
    @DisplayName("Decision Table Rule 8: Day 30, month with 30 days")
    void testRule8_Day30Month30Days() {
        assertEquals("1/5/2023", NextDate.getNextDate(30, 4, 2023));
        assertEquals("1/7/2023", NextDate.getNextDate(30, 6, 2023));
        assertEquals("1/10/2023", NextDate.getNextDate(30, 9, 2023));
        assertEquals("1/12/2023", NextDate.getNextDate(30, 11, 2023));
    }
    
    // Rule 9: Ngày 30, tháng có 31 ngày
    @Test
    @DisplayName("Decision Table Rule 9: Day 30, month with 31 days")
    void testRule9_Day30Month31Days() {
        assertEquals("31/1/2023", NextDate.getNextDate(30, 1, 2023));
        assertEquals("31/3/2023", NextDate.getNextDate(30, 3, 2023));
        assertEquals("31/5/2023", NextDate.getNextDate(30, 5, 2023));
    }
    
    // Rule 10: Ngày 30, tháng 2 → INVALID
    @Test
    @DisplayName("Decision Table Rule 10: Day 30, February → INVALID")
    void testRule10_Day30February() {
        assertEquals("INVALID", NextDate.getNextDate(30, 2, 2023));
        assertEquals("INVALID", NextDate.getNextDate(30, 2, 2024));
    }
    
    // Rule 11: Ngày 31, tháng có 31 ngày, không phải tháng 12
    @Test
    @DisplayName("Decision Table Rule 11: Day 31, month with 31 days, not Dec")
    void testRule11_Day31Month31DaysNotDec() {
        assertEquals("1/2/2023", NextDate.getNextDate(31, 1, 2023));
        assertEquals("1/4/2023", NextDate.getNextDate(31, 3, 2023));
        assertEquals("1/6/2023", NextDate.getNextDate(31, 5, 2023));
        assertEquals("1/8/2023", NextDate.getNextDate(31, 7, 2023));
        assertEquals("1/9/2023", NextDate.getNextDate(31, 8, 2023));
        assertEquals("1/11/2023", NextDate.getNextDate(31, 10, 2023));
    }
    
    // Rule 12: Ngày 31, tháng 12
    @Test
    @DisplayName("Decision Table Rule 12: Day 31, December")
    void testRule12_Day31December() {
        assertEquals("1/1/2024", NextDate.getNextDate(31, 12, 2023));
        assertEquals("1/1/2025", NextDate.getNextDate(31, 12, 2024));
    }
    
    // Rule 13: Ngày 31, tháng có 30 ngày → INVALID
    @Test
    @DisplayName("Decision Table Rule 13: Day 31, month with 30 days → INVALID")
    void testRule13_Day31Month30Days() {
        assertEquals("INVALID", NextDate.getNextDate(31, 4, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 6, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 9, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 11, 2023));
    }
    
    // Rule 14: Ngày 31, tháng 2 → INVALID
    @Test
    @DisplayName("Decision Table Rule 14: Day 31, February → INVALID")
    void testRule14_Day31February() {
        assertEquals("INVALID", NextDate.getNextDate(31, 2, 2023));
        assertEquals("INVALID", NextDate.getNextDate(31, 2, 2024));
    }
    
    // Rule 15: Ngày 32+ → INVALID
    @Test
    @DisplayName("Decision Table Rule 15: Day 32+ → INVALID")
    void testRule15_Day32Plus() {
        assertEquals("INVALID", NextDate.getNextDate(32, 1, 2023));
        assertEquals("INVALID", NextDate.getNextDate(32, 3, 2023));
        assertEquals("INVALID", NextDate.getNextDate(100, 5, 2023));
    }
    
    // Rule 16: Ngày 0 hoặc âm → INVALID
    @Test
    @DisplayName("Decision Table Rule 16: Day 0 or negative → INVALID")
    void testRule16_Day0OrNegative() {
        assertEquals("INVALID", NextDate.getNextDate(0, 5, 2023));
        assertEquals("INVALID", NextDate.getNextDate(-1, 5, 2023));
        assertEquals("INVALID", NextDate.getNextDate(-10, 5, 2023));
    }
    
    // Rule 17: Tháng 0 hoặc âm → INVALID
    @Test
    @DisplayName("Decision Table Rule 17: Month 0 or negative → INVALID")
    void testRule17_Month0OrNegative() {
        assertEquals("INVALID", NextDate.getNextDate(15, 0, 2023));
        assertEquals("INVALID", NextDate.getNextDate(15, -1, 2023));
        assertEquals("INVALID", NextDate.getNextDate(15, -5, 2023));
    }
    
    // Rule 18: Tháng 13+ → INVALID
    @Test
    @DisplayName("Decision Table Rule 18: Month 13+ → INVALID")
    void testRule18_Month13Plus() {
        assertEquals("INVALID", NextDate.getNextDate(15, 13, 2023));
        assertEquals("INVALID", NextDate.getNextDate(15, 20, 2023));
    }
    
    // Rule 19: Năm < 1812 → INVALID
    @Test
    @DisplayName("Decision Table Rule 19: Year < 1812 → INVALID")
    void testRule19_YearBelowMin() {
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 1811));
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 1800));
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 0));
        assertEquals("INVALID", NextDate.getNextDate(1, 1, -100));
    }
    
    // Rule 20: Năm > 2024 → INVALID
    @Test
    @DisplayName("Decision Table Rule 20: Year > 2024 → INVALID")
    void testRule20_YearAboveMax() {
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 2025));
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 2100));
        assertEquals("INVALID", NextDate.getNextDate(1, 1, 3000));
    }
    
    // Test decision table với các kết hợp phức tạp
    @Test
    @DisplayName("Complex Decision: 28/2/1900 (not leap)")
    void testComplex_28Feb1900() {
        assertEquals("1/3/1900", NextDate.getNextDate(28, 2, 1900));
    }
    
    @Test
    @DisplayName("Complex Decision: 28/2/2000 (leap)")
    void testComplex_28Feb2000() {
        assertEquals("29/2/2000", NextDate.getNextDate(28, 2, 2000));
    }
    
    @Test
    @DisplayName("Complex Decision: 29/2/1900 (not leap) → INVALID")
    void testComplex_29Feb1900() {
        assertEquals("INVALID", NextDate.getNextDate(29, 2, 1900));
    }
    
    @Test
    @DisplayName("Complex Decision: 29/2/2000 (leap)")
    void testComplex_29Feb2000() {
        assertEquals("1/3/2000", NextDate.getNextDate(29, 2, 2000));
    }
}
