package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_SIZE;
import static lotto.constant.LottoConstant.ONE;
import static lotto.constant.LottoConstant.ZERO;
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
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DUPLICATED.getMessage());
        }
        if (!isSorted(numbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_NOT_SORTED.getMessage());
        }
    }

    private boolean isSorted(List<Integer> numbers) {
        for (int i = ZERO; i < numbers.size(); i++) {
            if (i + ONE < numbers.size() && numbers.get(i) > numbers.get(i + ONE)) {
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
