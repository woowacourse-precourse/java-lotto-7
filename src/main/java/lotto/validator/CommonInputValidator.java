package lotto.validator;

public class CommonInputValidator {

    public static final String WHITE_SPACE = " ";
    public static final String ERROR_MESSAGE_INPUT_IS_EMPTY = "[ERROR] 입력 값이 비어있습니다.";
    public static final String ERROR_MESSAGE_INPUT_CONTAINS_WHITE_SPACE = "[ERROR] 입력 값에 공백이 포함되어 있습니다.";

    public static void validateCommonInput(String input) {
        validateIsNotEmptyInput(input);
        validateHasNoWhiteSpace(input);
    }

    private static void validateIsNotEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_IS_EMPTY);
        }
    }

    private static void validateHasNoWhiteSpace(String input) {
        if (input.contains(WHITE_SPACE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_INPUT_CONTAINS_WHITE_SPACE);
        }
    }
}
