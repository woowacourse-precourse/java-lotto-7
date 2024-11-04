package lotto;

import java.util.HashSet;
import java.util.List;

import static lotto.ErrorMessages.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_NULL);
        }
        validate(numbers);
        numbers = sortNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_EMPTY);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_SIZE);
        }
        if (!validateRange(numbers)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
        }
        if (!validateDuplicate(numbers)) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_DUPLICATE);
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    boolean validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    boolean validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            return false;
        }
        return true;
    }

    List<Integer> sortNumber(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public void printLotto() {
        System.out.println(numbers.toString());
    }


}
