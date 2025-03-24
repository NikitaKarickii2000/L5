import org.example.ArithmeticOperations;
import org.example.Factorial;
import org.example.NumberComparator;
import org.example.TriangleArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NewTest {
    @Test
    void testFactorial() {
        assertEquals(1, Factorial.calculateFactorial(0));
        assertEquals(120, Factorial.calculateFactorial(5));
        assertThrows(IllegalArgumentException.class, () -> Factorial.calculateFactorial(-1));
    }
    @Test
    void testTriangleArea() {
        assertEquals(10.0, TriangleArea.calculateArea(5, 4));
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.calculateArea(-2, 3));
    }
    @Test
    void testArithmetic() {
        assertEquals(8, ArithmeticOperations.add(5, 3));
        assertEquals(2, ArithmeticOperations.subtract(5, 3));
        assertEquals(15, ArithmeticOperations.multiply(5, 3));
        assertEquals(1.6, ArithmeticOperations.divide(5, 3), 0.100);
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(5, 0));
    }
    @Test
    void testComparison() {
        assertEquals("5 больше чем 3", NumberComparator.compare(5, 3));
        assertEquals("2 меньше 4", NumberComparator.compare(2, 4));
        assertEquals("7 равно 7", NumberComparator.compare(7, 7));
    }
}