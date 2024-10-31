package lotto;

import java.util.List;

public class BonusNumber {

    private final int value;

    public BonusNumber(final int value) {
        validate(value);
        this.value = value;
    }

    public boolean isMatchNumber(List<Integer> numbers) {
        return numbers.contains(value);
    }

    public int getValue() {
        return value;
    }

    private void validate(final int value) {
        final LottoNumberValidator lottoNumberValidator = new LottoNumberValidator();
        lottoNumberValidator.validateRange(value, 1, 45);
    }
}
