package lotto.util;

import lotto.view.Outputs;

public class MessageParser {

    public static String getMoneyErrorMessage(String message) {
        return String.join(Outputs.SPACE.getMessage(),
                Errors.ERROR.getMessage(),
                message,
                Errors.MONEY_REQUEST.getMessage());
    }

    public static String getLottoErrorMessage(String message) {
        return String.join(Outputs.SPACE.getMessage(),
                Errors.ERROR.getMessage(),
                message);
    }
}
