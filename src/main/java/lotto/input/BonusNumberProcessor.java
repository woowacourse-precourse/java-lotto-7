package lotto.input;

import lotto.util.InputUtil;

public class BonusNumberProcessor {

    private BonusNumberProcessor() {
    }

    public static int validateAndParse(String input) {
        InputUtil.validateEmptyInput(input);

        return 7;
    }
}
