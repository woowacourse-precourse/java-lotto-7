package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import java.util.List;
import lotto.util.InputUtil;
import lotto.util.utils;

public class BonusNumberProcessor {

    private BonusNumberProcessor() {
    }

    public static int validateAndParse(List<Integer> winNumber,String input) {
        InputUtil.validateEmptyInput(input);
        InputUtil.validatePositiveInteger(input);

        int bonusNumber = Integer.parseInt(input);

        utils.validateRange(bonusNumber);
        validateDuplicate(winNumber, bonusNumber);

        return bonusNumber;
    }


    private static void validateDuplicate(List<Integer> winNumber, int bonusNumber) {
        if (winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_WITH_WINNING_NUMBER.getMessage());
        }
    }
}
