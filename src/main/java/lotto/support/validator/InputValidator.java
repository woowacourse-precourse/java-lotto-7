package lotto.support.validator;

import java.util.List;
import lotto.exception.argument.validator.InvalidInputException;

public class InputValidator {

    public static void validateNotNullOrBlank(final String input, final String fieldName) {
        if (input == null) {
            throw new InvalidInputException(fieldName + "은(는) null일 수 없습니다.");
        }
        if (input.isBlank()) {
            throw new InvalidInputException(fieldName + "은(는) 빈 문자열이거나 공백일 수 없습니다.");
        }
    }

    public static void validateNotNullOrEmpty(final List<?> input, final String fieldName) {
        if (input == null) {
            throw new InvalidInputException(fieldName + "은(는) null일 수 없습니다.");
        }
        if (input.isEmpty()) {
            throw new InvalidInputException(fieldName + "은(는) 빈 문자열일 수 없습니다.");
        }
    }
}
