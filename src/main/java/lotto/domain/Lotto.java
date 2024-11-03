package lotto.domain;

import static lotto.exception.LottoErrorCode.LOTTO_NUMBERS_DUPLICATED;
import static lotto.exception.LottoErrorCode.LOTTO_NUMBERS_NOT_SORTED;
import static lotto.exception.LottoErrorCode.LOTTO_NUMBERS_OUT_OF_RANGE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
        if (!isSorted(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_SORTED.getMessage());
        }
    }

    private boolean isSorted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i + 1 < numbers.size() && numbers.get(i) > numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
