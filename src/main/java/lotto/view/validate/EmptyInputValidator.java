package lotto.view.validate;

public class EmptyInputValidator {

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "[ERROR] 입력값이 없습니다.";

    public static void validate(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

}
