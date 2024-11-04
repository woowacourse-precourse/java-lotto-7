package lotto.model;

import static lotto.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.exception.LottoErrorMessage.LOTTO_NUMBER_COUNT_INVALID;
import static lotto.exception.LottoErrorMessage.LOTTO_NUMBER_DUPLICATE;
import static lotto.exception.LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = new ArrayList<>(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_INVALID.message);
        }
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.message);
        }
        if (numbers.stream().anyMatch(m -> m < LOTTO_MIN_NUMBER || m > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.message);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int getMatchCount(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::contains).count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
