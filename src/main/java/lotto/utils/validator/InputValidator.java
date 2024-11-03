package lotto.utils.validator;

public class InputValidator implements Validator<String> {
    private static final String INPUT_IS_INTEGER = ErrorMessage + "숫자 형식의 입력이 필요합니다.";

    @Override
    public void validate(String value) {
        inputCharValidate(value);
    }

    private void inputCharValidate(String value) {
        if (!value.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_IS_INTEGER);
        }
    }

}
