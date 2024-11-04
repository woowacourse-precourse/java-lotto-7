package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixNumbers(numbers);
        validateLottoRange(numbers);
        validateLottoDuplicated(numbers);
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 필요합니다.");
        }
    }

    private static void validateLottoRange(List<Integer> numbers) {
        for (int number : numbers) {
            LottoNumber.validateNumberRange(number);
        }
    }

    private static void validateLottoDuplicated(List<Integer> numbers) {
        List<Integer> temp = new ArrayList<>();
        for (int number : numbers) {
            if (temp.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 공입니다.");
            }
            temp.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}