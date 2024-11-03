package lotto.validator;

public class InputValidator {
    private static final String INPUT_IS_BLANK_ERROR = "[ERROR] 입력이 공백입니다.";

    public void validateInputIsBlank(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException(INPUT_IS_BLANK_ERROR);
        }
    }
}
