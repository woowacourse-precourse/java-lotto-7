package lotto.view.validate;

public class LottoNumberRangeValidator {

    private static final String FORMAT_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이여야 합니다.";

    public static void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }
}
