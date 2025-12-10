package nextdate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class NextDateParameterizedTest {
    
    @ParameterizedTest(name = "Test {index}: {0}/{1}/{2} => {3}")
    @CsvSource({
        "31, 1, 2023, 1/2/2023",
        "28, 2, 2023, 1/3/2023",
        "28, 2, 2024, 29/2/2024",
        "29, 2, 2024, 1/3/2024",
        "30, 4, 2023, 1/5/2023",
        "31, 12, 2023, 1/1/2024",
        "15, 6, 2023, 16/6/2023",
        "1, 1, 1812, 2/1/1812",
        "31, 12, 2024, 1/1/2025"
    })
    void testValidDates(int day, int month, int year, String expected) {
        assertEquals(expected, NextDate.getNextDate(day, month, year));
    }
    
    @ParameterizedTest(name = "Test invalid {index}: {0}/{1}/{2} => INVALID")
    @CsvSource({
        "29, 2, 2023, INVALID",
        "31, 4, 2023, INVALID",
        "31, 6, 2023, INVALID",
        "31, 9, 2023, INVALID",
        "31, 11, 2023, INVALID",
        "32, 1, 2023, INVALID",
        "0, 5, 2023, INVALID",
        "15, 0, 2023, INVALID",
        "15, 13, 2023, INVALID",
        "1, 1, 1811, INVALID",
        "1, 1, 2025, INVALID"
    })
    void testInvalidDates(int day, int month, int year, String expected) {
        assertEquals(expected, NextDate.getNextDate(day, month, year));
    }
    
    static Stream<Object[]> validDateProvider() {
        return Stream.of(
            new Object[]{31, 1, 2023, "1/2/2023"},
            new Object[]{28, 2, 2023, "1/3/2023"},
            new Object[]{30, 4, 2023, "1/5/2023"},
            new Object[]{31, 7, 2023, "1/8/2023"},
            new Object[]{30, 9, 2023, "1/10/2023"},
            new Object[]{31, 12, 2023, "1/1/2024"}
        );
    }
    
    @ParameterizedTest
    @MethodSource("validDateProvider")
    void testValidDatesWithMethodSource(int day, int month, int year, String expected) {
        assertEquals(expected, NextDate.getNextDate(day, month, year));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1812, 1813, 2023, 2024})
    void testValidYearBoundaries(int year) {
        assertNotEquals("INVALID", NextDate.getNextDate(1, 1, year),
            "Năm " + year + " nên hợp lệ");
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1811, 0, -1, 2025, 3000})
    void testInvalidYearBoundaries(int year) {
        assertEquals("INVALID", NextDate.getNextDate(1, 1, year),
            "Năm " + year + " nên không hợp lệ");
    }
}
