package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateRanges(numbers);
        validateDuplicatedNumber(numbers);
    }

    public static void validateNumberCount(List<Integer> tokens) {
        if (tokens.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
        }
    }

    private void validateRanges(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 범위의 번호가 아닙니다.");
        }
    }

    public static void validateDuplicatedNumber(List<Integer> numbers) {
        boolean hasDuplicates = numbers.stream()
                .anyMatch(number -> Collections.frequency(numbers, number) > 1);

        if (hasDuplicates) {
            throw new IllegalArgumentException("[ERROR] 중복되는 번호가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
