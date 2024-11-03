package lotto;

import static lotto.LottoConstant.MAX_VALUE;
import static lotto.LottoConstant.MIN_VALUE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.ErrorMessage;

public class Validator {

    public static void validatePurchaseAmount(long input) {
        if (input % 1000 != 0 || input / 1000 < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_UNIT.getValue());
        }
    }

    public static void validateWinningNumbers(List<Integer> drawNumbers) {
        if (drawNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT_ERROR.getValue());
        }
        validateUniqueNumbers(drawNumbers);
        drawNumbers.forEach(Validator::validateNumberRange);
    }

    public static void validateBonusNumber(int drawNumber, List<Integer> winningNumbers) {
        validateNumberRange(drawNumber);
        if (winningNumbers.contains(drawNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getValue());
        }
    }

    public static void validateNumberRange(int drawNumber) {
        if (drawNumber >= MIN_VALUE && drawNumber <= MAX_VALUE) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR.getValue());
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_ERROR.getValue());
        }
    }
}
