package lotto.util;

import org.junit.platform.commons.util.StringUtils;

public class StringValidator {
    public static void validateEmptyString(final String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}
