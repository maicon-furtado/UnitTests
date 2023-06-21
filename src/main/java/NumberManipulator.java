import exceptions.ZeroOrNegativeValueException;

import java.util.ArrayList;
import java.util.List;

public class NumberManipulator {

    public int[] swapNumbers(int num1, int num2) {
        int[] numbers = {num1, num2};

        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];

        return numbers;
    }

    public List<Integer> fibonacci(int limit) throws ZeroOrNegativeValueException {

        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(0);

        if (limit > 1) {
            fibonacci.add(1);
            for (int i = 2; i < limit; i++) {
                fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
            }
        } else if (limit == 1) {
            return fibonacci;
        } else {
            throw new ZeroOrNegativeValueException();
        }
        return fibonacci;
    }

    public String validateNumberIsEvenOrOdd(int number) throws ZeroOrNegativeValueException {

        String classification;

        if (number <= 0)
            throw new ZeroOrNegativeValueException();
        else if (number % 2 == 0)
            classification = "The number " + number + " is Even";
        else
            classification = "The number " + number + " is Odd";

        return classification;
    }

    public boolean validateListHasOnlyEvenNumbers(List<Integer> ListOfNumbers)
            throws ZeroOrNegativeValueException {

        boolean classification = true;
        NumberManipulator numberManipulator = new NumberManipulator();

        for (int number : ListOfNumbers) {
            if (number <= 0) {
                throw new ZeroOrNegativeValueException();
            } else if (numberManipulator.validateNumberIsEvenOrOdd(number).
                    equals("The number " + number + "is Odd")) {
                classification = false;
                break;
            }
        }
        return classification;
    }


    public boolean validateListHasOnlyOddNumbers(List<Integer> ListOfNumbers)
            throws ZeroOrNegativeValueException {

        boolean classification = true;
        NumberManipulator numberManipulator = new NumberManipulator();

        for (int number : ListOfNumbers) {
            if (number <= 0) {
                throw new ZeroOrNegativeValueException();
            } else if (numberManipulator.validateNumberIsEvenOrOdd(number).
                    equals("The number " + number + "is Even")) {
                classification = false;
                break;
            }
        }
        return classification;
    }
}
