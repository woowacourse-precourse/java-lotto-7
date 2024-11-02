package lotto.util;

import lotto.view.Outputs;

public class MessageParser {

    public static String getComma(long number) {
        return String.format("%,d", number);
    }

    public static String getErrorMessage(String message) {
        return String.join(Outputs.SPACE.getMessage(),
                Errors.ERROR.getMessage(),
                message);
    }
}
