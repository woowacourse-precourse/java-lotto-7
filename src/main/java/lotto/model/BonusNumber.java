package lotto.model;

import java.util.List;
import message.ErrorMessage;

public class BonusNumber {
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        return new BonusNumber(bonusNumber);
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberIsInRange(bonusNumber);
        validateBonusNumberUniqueness(bonusNumber, winningNumbers);
    }

    private static void validateBonusNumberIsInRange(int bonusNumber) {
        if (isNumberOutOfRange(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_RANGE.message());
        }
    }

    private static void validateBonusNumberUniqueness(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.message());
        }
    }

    private static boolean isNumberOutOfRange(int number) {
        return number < MIN_BONUS_NUMBER || number > MAX_BONUS_NUMBER;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
