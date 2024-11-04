package lotto.input;

import lotto.util.InputUtil;
import lotto.util.LottoUtils;

public class BonusNumberProcessor {

    private BonusNumberProcessor() {
    }

    public static int validateAndParse(String input) {
        InputUtil.validateEmptyInput(input);
        InputUtil.validatePositiveInteger(input);

        int bonusNumber = Integer.parseInt(input);

        LottoUtils.validateRange(bonusNumber);

        return bonusNumber;
    }
}
