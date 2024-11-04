package lotto.input;

import static lotto.exception.ExceptionMessage.*;

import java.util.List;
import lotto.util.InputUtil;
import lotto.util.utils;

public class BonusNumberProcessor {

    private BonusNumberProcessor() {
    }

    public static int validateAndParse(String input) {
        InputUtil.validateEmptyInput(input);
        InputUtil.validatePositiveInteger(input);

        int bonusNumber = Integer.parseInt(input);

        utils.validateRange(bonusNumber);

        return bonusNumber;
    }
}
