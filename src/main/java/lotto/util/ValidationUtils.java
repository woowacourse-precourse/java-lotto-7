package lotto.util;

import org.junit.platform.commons.util.StringUtils;

public class ValidationUtils {
    public static void validateNotBlank(String input, String errorMessage) {
        if (StringUtils.isBlank(input.trim())) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static Long parseLong(String input, String errorMessage) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static Integer parseInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
