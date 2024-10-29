package lotto.view.validator;

public class InputValidator {

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "[ERROR] 공백은 입력할 수 없습니다.";

    public void validateNull(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }
}
