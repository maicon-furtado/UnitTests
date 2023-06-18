import exceptions.NegativeValueException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberManipulatorTest {

    NumberManipulator numberManipulator = new NumberManipulator();

    @Test
    void testSwapNumbers_returns_swapped_values() {

        int[] numbers = {20, 40};

        assertEquals(40, numberManipulator.swapNumbers(numbers[0], numbers[1])[0]);
        assertEquals(20, numberManipulator.swapNumbers(numbers[0], numbers[1])[1]);
    }

    @Test
    void testFibonacci_returns_requested_length() throws NegativeValueException {

        List<Integer> fibonacci = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        assertTrue(fibonacci.containsAll(numberManipulator.fibonacci(10)));

    }

    @Test
    void testFibonacci_returns_valid_value_when_length_is_2() throws NegativeValueException {

        List<Integer> fibonacci = Arrays.asList(0, 1);
        assertTrue(fibonacci.containsAll(numberManipulator.fibonacci(2)));

    }

    @Test
    void testFibonacci_returns_valid_value_when_length_is_1() throws NegativeValueException {

        List<Integer> fibonacci = Arrays.asList(0);
        assertTrue(fibonacci.containsAll(numberManipulator.fibonacci(1)));

    }

    @Test
    void testFibonacci_returns_valid_value_when_length_is_0_or_negative() throws NegativeValueException {

        Exception exception = assertThrows(NegativeValueException.class, () -> numberManipulator.fibonacci(0));
        assertEquals("Negative values are not accepted!", exception.getMessage());

        exception = assertThrows(NegativeValueException.class, () -> numberManipulator.fibonacci(-2));
        assertEquals("Negative values are not accepted!", exception.getMessage());

    }

}