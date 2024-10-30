package lotto.view.validate;

public class PositiveNumberValidator {

    private static final String POSITIVE_ERROR_MESSAGE = "[ERROR] 입력 값은 양수여야 합니다.";

    public static void validate(int number) {
        if (number < 0 || number == 0) {
            throw new IllegalArgumentException(POSITIVE_ERROR_MESSAGE);
        }
    }

}
