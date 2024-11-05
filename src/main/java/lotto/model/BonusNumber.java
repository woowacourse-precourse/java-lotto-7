package lotto.model;

import lotto.enumMessage.ErrorMessage;

public class BonusNumber {
    private final static int MIN_RANGE = 1;
    private final static int MAX_RANGE = 45;

    private final int number;

    public BonusNumber(int num, Lotto lotto) {
        validate(num, lotto);
        number = num;
    }

    private void validate(int num, Lotto lotto) {
        if (num < MIN_RANGE || num > MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_OUT_OF_RANGE.getMessage());
        }

        if (lotto.isDuplicateWithLotto(num)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }
}
