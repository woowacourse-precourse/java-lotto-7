package lotto.model;

import static lotto.Exception.ExceptionErrorMessage.DUPLICATED_LOTTO_NUMBER_MESSAGE;
import static lotto.Exception.ExceptionErrorMessage.OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE;
import static lotto.Exception.ExceptionErrorMessage.OUT_OF_RANGE_LOTTO_SIZE_MESSAGE;
import static lotto.constant.LottoValue.LOTTO_NUMBERS_LENGTH;
import static lotto.constant.LottoValue.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoValue.MIN_LOTTO_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_SIZE_MESSAGE.toString());
        }
        if (!isDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER_MESSAGE.toString());
        }
        if (!isLottoNumberInRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_LOTTO_NUMBER_MESSAGE.toString());
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return false;
            }
            set.add(number);
        }
        return true;
    }

    private boolean isLottoNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number >= MIN_LOTTO_NUMBER.getValue() && number <= MAX_LOTTO_NUMBER.getValue())) {
                return false;
            }
        }
        return true;
    }
}
