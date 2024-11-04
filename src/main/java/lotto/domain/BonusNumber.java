package lotto.domain;

import java.util.List;
import lotto.constant.LottoRule;
import lotto.util.NumberValidator;

public class BonusNumber {

    private final int value;

    public BonusNumber(final int value) {
        validate(value);
        this.value = value;
    }

    public boolean isMatchNumber(final Lotto lotto) {
        final List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(final int value) {
        final NumberValidator<Integer> numberValidator = NumberValidator.getInstance();
        numberValidator.validateRange(value, LottoRule.MIN_NUMBER, LottoRule.MAX_NUMBER);
    }
}
