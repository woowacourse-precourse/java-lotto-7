package lotto.domain;

import static lotto.constant.LottoGameRule.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.MIN_LOTTO_NUMBER;
import static lotto.exception.ErrorMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;

import java.util.List;
import lotto.exception.LottoException;
import lotto.utils.InputParser;

public class BonusNumber {
    private final int number;

    public BonusNumber(Lotto winningLotto, String input) {
        int number = InputParser.parseBonusNumber(input);
        validate(winningLotto, number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(Lotto winningLotto, int number) {
        validateRange(number);
        validateDuplicate(winningLotto.getNumbers(), number);
    }

    private void validateRange(int number) {
        if (isOutOfBounds(number)) {
            throw new LottoException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers, int number) {
        if (isDuplicate(numbers, number)) {
            throw new LottoException(BONUS_NUMBER_DUPLICATE);
        }
    }

    private boolean isOutOfBounds(int number) {
        return number < MIN_LOTTO_NUMBER.getValue() ||
                number > MAX_LOTTO_NUMBER.getValue();
    }

    private boolean isDuplicate(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }
}
