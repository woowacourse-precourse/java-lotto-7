package lotto.validation;

import lotto.enums.Message;

public class InputValidator {

    private InputValidator() {}

    public static void validateNonBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(Message.ERROR_PREFIX.getMessage() + "입력값이 비어 있거나 공백으로만 구성되었습니다.");
        }
    }

    public static void validateDelimitedByComma(String input) {
        if (!input.matches("^\\d+(,\\d+)*$")) {
            throw new IllegalArgumentException(Message.ERROR_PREFIX.getMessage() + "당첨 번호 입력 시, 쉼표(,)로 구분해야 합니다.");
        }
    }
}

