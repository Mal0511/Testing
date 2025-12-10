package testtingsoftware.com.Triangle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * KIỂM THỬ TAM GIÁC BẰNG BẢNG QUYẾT ĐỊNH (DECISION TABLE)
 * 
 * Điều kiện (Conditions):
 * C1: Có cạnh ≤ 0 ?
 * C2: Ba cạnh có thỏa mãn bất đẳng thức tam giác? (a + b > c, a + c > b, b + c > a)
 * C3: a = b = c ?
 * C4: a = b hoặc b = c hoặc a = c ?
 * C5: Có vuông? (a^2 + b^2 = c^2 hoặc tương tự)
 * 
 * Hành động (Actions):
 * A1: "Invalid" – nếu cạnh ≤ 0 hoặc không tạo thành tam giác
 * A2: "Deu" – tam giác đều
 * A3: "Can" – tam giác cân
 * A4: "Vuong" – tam giác vuông
 * A5: "Vuong can" – tam giác vuông cân
 * A6: "Nhon" – tam giác nhọn
 * A7: "Tu" – tam giác tù
 */

public class TestTriangleDecisionTable {

    @Test
    @DisplayName("Rule 1: Một cạnh ≤ 0 → Invalid")
    void testRule1_InvalidSides() {
        Triangle t1 = new Triangle(0, 5, 7);
        assertEquals("Invalid", t1.CheckTriangleType());
        Triangle t2 = new Triangle(-3, 4, 5);
        assertEquals("Invalid", t2.CheckTriangleType());
        Triangle t3 = new Triangle(5, -2, 8);
        assertEquals("Invalid", t3.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 2: Không thỏa mãn bất đẳng thức tam giác → Invalid")
    void testRule2_NotTriangle() {
        Triangle t = new Triangle(1, 2, 3);
        assertEquals("Invalid", t.CheckTriangleType());
    }
    @Test
    @DisplayName("Rule 3: Tam giác đều (a = b = c)")
    void testRule3_Equilateral() {
        Triangle t = new Triangle(5, 5, 5);
        assertEquals("Deu", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 4: Tam giác vuông cân")
    void testRule4_RightIsosceles() {
        Triangle t = new Triangle(1, 1, Math.sqrt(2));
        assertEquals("Vuong can", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 5: Tam giác cân không vuông")
    void testRule5_Isosceles() {
        Triangle t = new Triangle(5, 5, 6);
        assertEquals("Can", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 6: Tam giác vuông không cân")
    void testRule6_Right() {
        Triangle t = new Triangle(3, 4, 5);
        assertEquals("Vuong", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 7: Tam giác nhọn")
    void testRule7_Acute() {
        Triangle t = new Triangle(4, 5, 6);
        assertEquals("Nhon", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 8: Tam giác tù")
    void testRule8_Obtuse() {
        Triangle t = new Triangle(3, 4, 6);
        assertEquals("Tu", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 9: Biên hợp lệ nhỏ nhất (1,1,1)")
    void testRule9_MinBoundary() {
        Triangle t = new Triangle(1, 1, 1);
        assertEquals("Deu", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 10: Cạnh lớn hơn biên")
    void testRule10_LargeSides() {
        Triangle t = new Triangle(201, 201, 201);
        assertEquals("Invalid", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 11: Một cạnh cực nhỏ → Invalid")
    void testRule11_TooSmallSide() {
        Triangle t = new Triangle(1, 100, 101);
        assertEquals("Invalid", t.CheckTriangleType());
    }
    @Test
    @DisplayName("Rule 12: Tam giác cân gần vuông")
    void testRule12_NearRightIsosceles() {
        Triangle t = new Triangle(5, 5, 7.07); 
        assertEquals("Can", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 13: Vuông với số thực")
    void testRule13_RightFloat() {
        Triangle t = new Triangle(2.5, 6, Math.sqrt(2.5*2.5 + 6*6));
        assertEquals("Vuong", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 14: Tam giác cân nhỏ (0.5, 0.5, 0.8)")
    void testRule14_SmallIsosceles() {
        Triangle t = new Triangle(0.5, 0.5, 0.8);
        assertEquals("Can", t.CheckTriangleType());
    }

    @Test
    @DisplayName("Rule 15: Tổng hai cạnh bằng cạnh còn lại → Invalid")
    void testRule15_EqualSumInvalid() {
        Triangle t = new Triangle(3, 4, 7);
        assertEquals("Invalid", t.CheckTriangleType());
    }
}
