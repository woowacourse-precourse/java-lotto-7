package lotto.view.validate;

public class NumberFormatValidator {

    private static final String FORMAT_ERROR_MESSAGE = "[ERROR] 입력 값은 숫자 형식이어야 합니다.";

    public static void validate(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }
}
