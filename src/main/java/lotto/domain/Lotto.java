package lotto.domain;

import java.util.List;
import lotto.util.ErrorUtil;
import lotto.util.NumberUtil;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize();
        validateNumberRepeat();
        validateNumberRange();
    }

    private void validateNumberSize() {
        if (numbers.size() != NumberUtil.MAX_PICK_NUMBER) {
            ErrorUtil.WINNING_LOTTO_SIZE_ERROR_MESSAGE.errorException();
        }
    }

    private void validateNumberRange() {
        for (int number : numbers) {
            if (number > NumberUtil.MAX_RANGE_NUMBER || number < NumberUtil.MINIMUM_RANGE_NUMBER) {
                ErrorUtil.WINNING_LOTTO_RANGE_ERROR_MESSAGE.errorException();
            }
        }
    }

    private void validateNumberRepeat() {
        if (lottoSize() != numbers.size()) {
            ErrorUtil.WINNING_LOTTO_REPEAT_ERROR_MESSAGE.errorException();
        }
    }

    private int lottoSize() {
        return numbers
                .stream()
                .distinct()
                .toList()
                .size();
    }
}
