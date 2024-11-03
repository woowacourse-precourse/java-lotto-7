package lotto.helper.valid;

import java.util.List;
import lotto.config.exception.bonus.BonusException;
import lotto.config.exception.bonus.BonusExceptionMessage;


public class ValidBonus {

    public static void checkDuplicateNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new BonusException(BonusExceptionMessage.HAS_DUPLICATE_BONUS_NUMBER);
        }
    }

    public static void checkRangeNumber(int number) {
        if (number < 1 || number > 45) {
            throw new BonusException(BonusExceptionMessage.NOT_RANGE_BONUS_NUMBER);
        }
    }

}
