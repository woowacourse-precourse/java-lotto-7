package lotto.utility;

public class BonusNumberValidator {
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validateUnderFourtySix(int bonusNumber) {
        if (bonusNumber > MAX_LOTTO_NUMBER) {
            System.out.println(ExceptionEnum.CANNOT_OVER_FOURTY_SIX.getMessage());
            throw new IllegalArgumentException(ExceptionEnum.CANNOT_OVER_FOURTY_SIX.getMessage());
        }
    }
}
