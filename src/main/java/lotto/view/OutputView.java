package lotto.view;

import static lotto.common.Constants.ERROR_PROMPT;

public class OutputView {
    public static String getErrorMessage (String errorMessage) {
        return ERROR_PROMPT + errorMessage;
    }
}
