import org.junit.jupiter.api.Test;

import com.example.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorTest {

    @Test
    public void testSquareRoot() {
        assertEquals(4, Calculator.squareRoot(16), 0.0001, "Square root of 16 should be 4");
        assertEquals(0, Calculator.squareRoot(0), 0.0001, "Square root of 0 should be 0");
        assertEquals(-1, Calculator.squareRoot(-25), 0.0001, "Square root of negative numbers should return -1");
    }

    @Test
    public void testFactorial() {
        assertEquals(120, Calculator.factorial(5), "Factorial of 5 should be 120");
        assertEquals(1, Calculator.factorial(0), "Factorial of 0 should be 1");
        assertEquals(-1, Calculator.factorial(-5), "Factorial of negative numbers should return -1");
    }

    @Test
    public void testNaturalLogarithm() {
        assertEquals(0, Calculator.naturalLogarithm(1), 0.0001, "ln(1) should be 0");
        assertEquals(-1, Calculator.naturalLogarithm(0), 0.0001, "ln(0) should return -1 (undefined)");
        assertEquals(-1, Calculator.naturalLogarithm(-5), 0.0001, "ln(negative number) should return -1 (undefined)");
    }

    @Test
    public void testPower() {
        assertEquals(8, Calculator.power(2, 3), 0.0001, "2^3 should be 8");
        assertEquals(1, Calculator.power(5, 0), 0.0001, "Any number to the power of 0 should be 1");
        assertEquals(0.5, Calculator.power(2, -1), 0.0001, "2^-1 should be 0.5");
    }
}
