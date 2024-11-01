package lotto.domain;

import lotto.error.LottoError;

public class BonusNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    private BonusNumber(int number, WinningLotto winningLotto) {
        validate(number, winningLotto);
        this.number = number;
    }

    public static BonusNumber of(int number, WinningLotto winningLotto) {
        return new BonusNumber(number, winningLotto);
    }

    private void validate(int number, WinningLotto winningLotto) {
        validateDuplicationNumber(number, winningLotto);
        validateLessThanLottoNumberMax(number);
        validateMoreThanLottoNumberMin(number);
    }

    private void validateDuplicationNumber(int number, WinningLotto winningLotto) {
        if (winningLotto.isContains(number)) {
            throw new IllegalArgumentException(LottoError.LOTTO_BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    private void validateMoreThanLottoNumberMin(int number) {
        if (number < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_LESS_THAN_MIN.getMessage());
        }
    }

    private void validateLessThanLottoNumberMax(int number) {
        if (number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoError.LOTTO_NUMBER_MORE_THAN_MAX.getMessage());
        }
    }

    public boolean isMatch(int number) {
        return this.number == number;
    }
}
