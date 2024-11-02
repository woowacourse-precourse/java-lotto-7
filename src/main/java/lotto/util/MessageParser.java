package lotto.util;

import lotto.view.Outputs;

public class MessageParser {

    public static String combineMessages(String message) {
        return String.join(Outputs.SPACE.getMessage(),
                Errors.ERROR.getMessage(),
                message,
                Errors.NUMBER_REQUEST.getMessage());
    }
}
