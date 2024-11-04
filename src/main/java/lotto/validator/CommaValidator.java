package lotto.validator;

import static lotto.constant.ErrorCode.CONTIGIOUS_COMMA;

import lotto.view.OutputView;

public class CommaValidator {

    private static final String COMMAS = ",,";

    public static void validate(String input) {
        if (input.contains(COMMAS)) {
            OutputView.printError(CONTIGIOUS_COMMA.getMessage());
        }
    }
}