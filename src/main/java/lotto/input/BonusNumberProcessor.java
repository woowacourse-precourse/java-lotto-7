package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import java.util.List;
import lotto.util.InputUtil;

public class BonusNumberProcessor {

    private BonusNumberProcessor() {
    }

    public static int validateAndParse(List<Integer> winNumber,String input) {
        InputUtil.validateEmptyInput(input);
        InputUtil.validatePositiveInteger(input);

        int bonusNumber = Integer.parseInt(input);

        validateRange(bonusNumber);
        validateDuplicate(winNumber, bonusNumber);

        return bonusNumber;
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> winNumber, int bonusNumber) {
        if (winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_WINNING_NUMBER.getMessage());
        }
    }
}
