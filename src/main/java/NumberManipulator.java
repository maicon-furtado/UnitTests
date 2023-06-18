import exceptions.NegativeValueException;
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

    public List<Integer> fibonacci(int limit) throws NegativeValueException {

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
            throw new NegativeValueException();
        }
        return fibonacci;
    }
}
