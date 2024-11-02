package lotto.Model;

import lotto.Enum.ExceptionCode;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        // LOTTO_01
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        // LOTTO_02
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_RANGE.getMessage());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort((num1, num2) -> {
            int compared = num1.compareTo(num2);
            if (compared == 0) {
                throw new IllegalArgumentException(ExceptionCode.DUPLICATED_NUMBER.getMessage());
            }
            return compared;
        });
        return sortedNumbers;
    }
}
