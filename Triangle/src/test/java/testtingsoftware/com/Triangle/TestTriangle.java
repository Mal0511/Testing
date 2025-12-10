package testtingsoftware.com.Triangle;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestTriangle {

    @Test
    void TC_TRI_01() {
        assertEquals("Deu", new Triangle(1, 1, 1).CheckTriangleType());
    }

    @Test
    void TC_TRI_02() {
        assertEquals("Invalid", new Triangle(1, 1, 2).CheckTriangleType());
    }

    @Test
    void TC_TRI_03() {
        assertEquals("Invalid", new Triangle(1, 1, 3).CheckTriangleType());
    }

    @Test
    void TC_TRI_04() {
        assertEquals("Can", new Triangle(2, 2, 3).CheckTriangleType());
    }

    @Test
    void TC_TRI_05() {
        assertEquals("Tu", new Triangle(2, 3, 4).CheckTriangleType());
    }

    @Test
    void TC_TRI_06() {
        assertEquals("Deu", new Triangle(100, 100, 100).CheckTriangleType());
    }

    @Test
    void TC_TRI_07() {
        assertEquals("Deu", new Triangle(199, 199, 199).CheckTriangleType());
    }

    @Test
    void TC_TRI_08() {
        assertEquals("Can", new Triangle(199, 199, 200).CheckTriangleType());
    }

    @Test
    void TC_TRI_09() {
        assertEquals("Invalid", new Triangle(199, 199, 398).CheckTriangleType());
    }

    @Test
    void TC_TRI_10() {
        assertEquals("Deu", new Triangle(200, 200, 200).CheckTriangleType());
    }

    @Test
    void TC_TRI_11() {
        assertEquals("Invalid", new Triangle(200, 200, 399).CheckTriangleType());
    }

    @Test
    void TC_TRI_12() {
        assertEquals("Invalid", new Triangle(1, 2, 3).CheckTriangleType());
    }

    @Test
    void TC_TRI_13() {
        assertEquals("Invalid", new Triangle(2, 2, 4).CheckTriangleType());
    }

    @Test
    void TC_TRI_14() {
        assertEquals("Invalid", new Triangle(2, 3, 5).CheckTriangleType());
    }

    @Test
    void TC_TRI_15() {
        assertEquals("Vuong", new Triangle(3, 4, 5).CheckTriangleType());
    }

    @Test
    void TC_TRI_16() {
        assertEquals("Deu", new Triangle(5, 5, 5).CheckTriangleType());
    }

    @Test
    void TC_TRI_17() {
        assertEquals("Can", new Triangle(6, 6, 5).CheckTriangleType());
    }

    @Test
    void TC_TRI_18() {
        assertEquals("Nhon", new Triangle(7, 8, 9).CheckTriangleType());
    }

    @Test
    void TC_TRI_19() {
        assertEquals("Vuong", new Triangle(5, 12, 13).CheckTriangleType());
    }

    @Test
    void TC_TRI_20() {
        assertEquals("Vuong", new Triangle(7, 24, 25).CheckTriangleType());
    }

    @Test
    void TC_TRI_21() {
        assertEquals("Can", new Triangle(5, 5, 7).CheckTriangleType());
    }

    @Test
    void TC_TRI_22() {
        assertEquals("Tu", new Triangle(9, 10, 17).CheckTriangleType());
    }

    @Test
    void TC_TRI_23() {
        assertEquals("Invalid", new Triangle(8, 8, 16).CheckTriangleType());
    }

    @Test
    void TC_TRI_24() {
        assertEquals("Nhon", new Triangle(4, 5, 6).CheckTriangleType());
    }

    @Test
    void TC_TRI_25() {
        assertEquals("Can", new Triangle(10, 10, 14).CheckTriangleType());
    }

    @Test
    void TC_TRI_26() {
        assertEquals("Vuong", new Triangle(3, 4, 5).CheckTriangleType());
    }

    @Test
    void TC_TRI_27() {
        assertEquals("Vuong", new Triangle(4, 3, 5).CheckTriangleType());
    }

    @Test
    void TC_TRI_28() {
        assertEquals("Vuong", new Triangle(5, 4, 3).CheckTriangleType());
    }

    @Test
    void TC_TRI_29() {
        assertEquals("Can", new Triangle(2, 3, 2).CheckTriangleType());
    }

    @Test
    void TC_TRI_30() {
        assertEquals("Can", new Triangle(2, 2, 3).CheckTriangleType());
    }

    @Test
    void TC_TRI_31() {
        assertEquals("Invalid", new Triangle(100, 99, 1).CheckTriangleType());
    }

    @Test
    void TC_TRI_32() {
        assertEquals("Invalid", new Triangle(99, 1, 100).CheckTriangleType());
    }

    @Test
    void TC_TRI_33() {
        assertEquals("Invalid", new Triangle(0, 5, 6).CheckTriangleType());
    }

    @Test
    void TC_TRI_34() {
        assertEquals("Invalid", new Triangle(-1, 5, 6).CheckTriangleType());
    }

    @Test
    void TC_TRI_35() {
        assertEquals("Invalid", new Triangle(0, 0, 0).CheckTriangleType());
    }

    @Test
    void TC_TRI_36() {
        assertEquals("Invalid", new Triangle(-5, -5, -5).CheckTriangleType());
    }

    @Test
    void TC_TRI_37() {
        assertEquals("Invalid", new Triangle(1, 2000, 2000).CheckTriangleType());
    }

    @Test
    void TC_TRI_38() {
        assertEquals("Invalid", new Triangle(201, 200, 200).CheckTriangleType());
    }

    @Test
    void TC_TRI_39() {
        assertEquals("Invalid", new Triangle(1, 1, 0).CheckTriangleType());
    }

    @Test
    void TC_TRI_40() {
        assertEquals("Vuong", new Triangle(3.0, 4.0, 5.0).CheckTriangleType());
    }

    @Test
    void TC_TRI_41() {
        assertEquals("Tu", new Triangle(3.5, 4.5, 7.9).CheckTriangleType());
    }

    @Test
    void TC_TRI_42() {
        assertThrows(NumberFormatException.class, () -> {
            Double a = Double.valueOf("a");
            new Triangle(a, 6, 3).CheckTriangleType();
        });
    }

    @Test
    void TC_TRI_43() {
        assertThrows(NumberFormatException.class, () -> {
            Double a = Double.valueOf(" ");
            new Triangle(a, 3, 8).CheckTriangleType();
        });
    }

    @Test
    void TC_TRI_44() {
        double a = Double.parseDouble("3");
        double b = Double.parseDouble("5");
        double c = Double.parseDouble("6");
        assertEquals("Tu", new Triangle(a, b, c).CheckTriangleType());
    }

    @Test
    void TC_TRI_45() {
        double a = Double.parseDouble("03");
        double b = Double.parseDouble("04");
        double c = Double.parseDouble("05");
        assertEquals("Vuong", new Triangle(a, b, c).CheckTriangleType());
    }

    @Test
    void TC_TRI_46() {
        double a = Double.parseDouble(" 3".trim());
        double b = Double.parseDouble("4 ".trim());
        double c = Double.parseDouble("5");
        assertEquals("Vuong", new Triangle(a, b, c).CheckTriangleType());
    }

    @Test
    void TC_TRI_47() {
        double a = Double.parseDouble("1e2");
        assertEquals("Deu", new Triangle(a, 100, 100).CheckTriangleType());
    }

    @Test
    void TC_TRI_48() {
        assertEquals("Deu", new Triangle(1, 1, 1).CheckTriangleType());
    }

    @Test
    void TC_TRI_49() {
        assertEquals("Invalid", new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE).CheckTriangleType());
    }

    @Test
    void TC_TRI_50() {
        assertThrows(NullPointerException.class, () -> {
            Double a = null;
            new Triangle(a, 5, 6).CheckTriangleType();
        });
    }
}
