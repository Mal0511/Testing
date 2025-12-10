package testtingsoftware.com.Triangle;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class TestTriangleCombinatorial {

    @Test
    public void testEquilateralTriangle() {
        Triangle t = new Triangle(5, 5, 5);
        assertEquals("Deu", t.CheckTriangleType());
    }

    @Test
    public void testIsoscelesTriangle() {
        Triangle t = new Triangle(5, 5, 3);
        assertEquals("Can", t.CheckTriangleType());
    }

    @Test
    public void testRightTriangle() {
        Triangle t = new Triangle(3, 4, 5);
        assertEquals("Vuong", t.CheckTriangleType());
    }

    @Test
    public void testRightIsoscelesTriangle() {
        Triangle t = new Triangle(1, 1, Math.sqrt(2));
        assertEquals("Vuong can", t.CheckTriangleType());
    }

    @Test
    public void testAcuteTriangle() {
        Triangle t = new Triangle(4, 5, 6);
        assertEquals("Nhon", t.CheckTriangleType());
    }

    @Test
    public void testObtuseTriangle() {
        Triangle t = new Triangle(3, 5, 7);
        assertEquals("Tu", t.CheckTriangleType());
    }

    @Test
    public void testInvalidTriangle_NegativeSide() {
        Triangle t = new Triangle(-1, 2, 3);
        assertEquals("Invalid", t.CheckTriangleType());
    }

    @Test
    public void testInvalidTriangle_ZeroSide() {
        Triangle t = new Triangle(0, 4, 5);
        assertEquals("Invalid", t.CheckTriangleType());
    }

    @Test
    public void testInvalidTriangle_NotTriangle() {
        Triangle t = new Triangle(1, 2, 3);
        assertEquals("Invalid", t.CheckTriangleType());
    }
}
