import org.example.ArithmeticOperations;
import org.example.Factorial;
import org.example.NumberComparator;
import org.example.TriangleArea;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NewTest {

        @Test
    public void testNumberComparison() {
        assertEquals(NumberComparator.compare(5, 3), "5 больше чем 3");
        assertEquals(NumberComparator.compare(2, 4), "2 меньше чем 4");
        assertEquals(NumberComparator.compare(7, 7), "7 равно 7");
    }

    @Test
    public void testArithmeticOperations() {
        assertEquals(ArithmeticOperations.add(5, 3), 8);
        assertEquals(ArithmeticOperations.subtract(5, 3), 2);
        assertEquals(ArithmeticOperations.multiply(5, 3), 15);
        assertEquals(ArithmeticOperations.divide(6, 3), 2.0);
    }

    @Test(expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "Деление на ноль")
    public void testDivisionByZero() {
        ArithmeticOperations.divide(5, 0);
    }

    @Test
    public void testTriangleAreaCalculation() {
        assertEquals(TriangleArea.calculateArea(5, 4), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Значения должны быть положительные")
    public void testInvalidTriangleParameters() {
        TriangleArea.calculateArea(-2, 3);
    }

    @Test
    public void testFactorialCalculation() {
        assertEquals(Factorial.calculateFactorial(5), 120L);
        assertEquals(Factorial.calculateFactorial(0), 1L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Отрицательные числа не допускаются")
    public void testNegativeFactorial() {
        Factorial.calculateFactorial(-1);
    }
}