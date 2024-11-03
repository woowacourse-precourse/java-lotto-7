package lotto.utility;

public class BonusNumberValidator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateUnderFourtySix(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_UNDER_ZERO.getMessage());
        }

        if (bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_OVER_FOURTY_SIX.getMessage());
        }
    }
}
