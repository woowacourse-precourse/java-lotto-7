package lotto.util;

import lotto.constant.ExceptionMessage;
import org.junit.platform.commons.util.StringUtils;

public class StringValidator {
    public static void validateEmptyString(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY_STRING.getMessage());
        }
    }
}
