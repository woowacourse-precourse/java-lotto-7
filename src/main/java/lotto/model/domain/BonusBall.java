package lotto.model.domain;

import lotto.model.ErrorMessage;

public class BonusBall {

    private final int number;

    public static BonusBall of(int number, WinningBalls winningBalls) {
        validateRange(number);
        validateDuplicate(number, winningBalls);
        return new BonusBall(number);
    }

    private static void validateRange(int number) {
        if (number < 0 || number > 46) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateDuplicate(int number, WinningBalls winningBalls) {
        if (!winningBalls.isDistinct(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }
    }

    private BonusBall(int number) {
        this.number = number;
    }

    public int getSameNumberCount(Lotto userLotto) {
        if (userLotto.hasNumber(number)) {
            return 1;
        }
        return 0;
    }

    protected int getNumber() {
        return this.number;
    }
}

