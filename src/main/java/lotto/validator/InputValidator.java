package lotto.validator;

public class InputValidator extends Validator {
    private static final String INPUT_IS_BLANK_ERROR = "[ERROR] 입력이 공백입니다.";
    String input;

    public InputValidator(String input) {
        this.input = input;
    }

    @Override
    public void validate() throws IllegalArgumentException {
        validateInputIsBlank();
    }

    public void validateInputIsBlank() {
        if(input.isBlank()){
            throw new IllegalArgumentException(INPUT_IS_BLANK_ERROR);
        }
    }
}
