package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.common.ErrorMessage;
import lotto.common.LottoConstants;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public List<Integer> get() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(this::isOutOfRange)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE);
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER;
    }
}
