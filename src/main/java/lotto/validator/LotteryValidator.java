package lotto.validator;

import lotto.common.error.BonusNumErrorMessage;

import java.util.List;

public class LotteryValidator {
    private LotteryValidator() {}

    public static void validateValueRange(int num) {
        boolean isValid = (num >= 1 && num <= 45);
        if (!isValid) {
            throw new IllegalArgumentException(BonusNumErrorMessage.INVALID_BONUS_NUMBER.getInfoMessage());
        }
    }
    public static void validateDuplicate(List<Integer> numbers, int bonusNum) {
        boolean isValid = !numbers.contains(bonusNum);
        if (!isValid) {
            throw new IllegalArgumentException(BonusNumErrorMessage.CONFLICT_BONUS_NUMBER.getInfoMessage());
        }
    }
}
