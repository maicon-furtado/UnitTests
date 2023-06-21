import exceptions.ZeroOrNegativeValueException;
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
    void testFibonacci_returns_requested_length() throws ZeroOrNegativeValueException {

        List<Integer> fibonacci = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        assertTrue(fibonacci.containsAll(numberManipulator.fibonacci(10)));

    }

    @Test
    void testFibonacci_returns_valid_value_when_length_is_2() throws ZeroOrNegativeValueException {

        List<Integer> fibonacci = Arrays.asList(0, 1);
        assertTrue(fibonacci.containsAll(numberManipulator.fibonacci(2)));

    }

    @Test
    void testFibonacci_returns_valid_value_when_length_is_1() throws ZeroOrNegativeValueException {

        List<Integer> fibonacci = Arrays.asList(0);
        assertTrue(fibonacci.containsAll(numberManipulator.fibonacci(1)));

    }

    @Test
    void testFibonacci_returns_valid_value_when_length_is_0_or_negative() {

        Exception exception = assertThrows(ZeroOrNegativeValueException.class, () -> numberManipulator.fibonacci(0));
        assertEquals("Zero or negative values are not accepted!", exception.getMessage());

        exception = assertThrows(ZeroOrNegativeValueException.class, () -> numberManipulator.fibonacci(-2));
        assertEquals("Zero or negative values are not accepted!", exception.getMessage());

    }

    @Test
    void testValidateNumberIsEvenOrOdd_returns_Even() throws ZeroOrNegativeValueException {

        assertEquals("The number " + 2 + " is Even", numberManipulator.validateNumberIsEvenOrOdd(2));

    }

    @Test
    void testValidateNumberIsEvenOrOdd_returns_Odd() throws ZeroOrNegativeValueException {

        assertEquals("The number " + 1 + " is Odd", numberManipulator.validateNumberIsEvenOrOdd(1));

    }

    @Test
    void testValidateNumberIsEvenOrOdd_returns_ZeroOrNegativeValueException() {

        Exception exception = assertThrows(ZeroOrNegativeValueException.class,
                () -> numberManipulator.validateNumberIsEvenOrOdd(0));
        assertEquals("Zero or negative values are not accepted!", exception.getMessage());

        exception = assertThrows(ZeroOrNegativeValueException.class,
                () -> numberManipulator.validateNumberIsEvenOrOdd(-20));
        assertEquals("Zero or negative values are not accepted!", exception.getMessage());
    }

    @Test
    void testValidateListHasOnlyEvenNumbers_returns_true() throws ZeroOrNegativeValueException {

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 12);
        assertTrue(numberManipulator.validateListHasOnlyEvenNumbers(numbers));

    }

    @Test
    void testValidateListHasOnlyEvenNumbers_returns_false() throws ZeroOrNegativeValueException {

        List<Integer> numbers = Arrays.asList(3, 4, 6, 8, 10, 12);
        assertTrue(numberManipulator.validateListHasOnlyEvenNumbers(numbers));

    }

    @Test
    void testValidateListHasOnlyOddNumbers_returns_true() throws ZeroOrNegativeValueException {

        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 11);
        assertTrue(numberManipulator.validateListHasOnlyEvenNumbers(numbers));

    }

    @Test
    void testValidateListHasOnlyOddNumbers_returns_false() throws ZeroOrNegativeValueException {

        List<Integer> numbers = Arrays.asList(54, 5, 5, 65, 16, 13);
        assertTrue(numberManipulator.validateListHasOnlyEvenNumbers(numbers));

    }

    @Test
    void testValidateListHasOnlyOddNumbers_returns_ZeroOrNegativeValueException() {

        List<Integer> numbers = Arrays.asList(9, 1, -5, 65, 0, 13);

        Exception exception = assertThrows(ZeroOrNegativeValueException.class,
                () -> numberManipulator.validateListHasOnlyEvenNumbers(numbers));
        assertEquals("Zero or negative values are not accepted!", exception.getMessage());

    }

    @Test
    void testSortNumbers_returns_sorted_sequence() {

        NumberManipulator numberManipulator = new NumberManipulator();

        int[] shuffledNumbers = {1, 34, 35634, 36, 7665, 875, 236, 573, 12113, 6904, -33, -4854, 0};

        int[] sortedNumbers = {-4854, -33, 0, 1, 34, 36, 236, 573, 875, 6904, 7665, 12113, 35634};

        assertArrayEquals(sortedNumbers, numberManipulator.sortNumbers(shuffledNumbers));
    }


}