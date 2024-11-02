package lotto.validator;

import lotto.exception.RetryInputException;
import lotto.status.ErrorMessages;
import lotto.util.RegexUtils;

public class CommonValidator {

    public static Boolean nonEmpty(String viewMessage, String input) {
        if (!input.isEmpty()) {
            return true;
        }

        throw new RetryInputException(viewMessage, input);
    }

    public static Boolean isNumeric(String viewMessage, String input) {
        if (RegexUtils.isNumeric(input)) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.NON_NUMERIC.getMessage());
    }

    public static Boolean isPositiveNumber(String viewMessage, String input) {
        if (RegexUtils.isPositiveNumeric(input)) {
            return true;
        }

        throw new RetryInputException(viewMessage, ErrorMessages.NON_POSITIVE_NUMERIC.getMessage());
    }
}
