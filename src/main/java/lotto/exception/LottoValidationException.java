package lotto.exception;

public class LottoValidationException extends IllegalArgumentException {

    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String DUPLICATED_INPUT_ERROR = "로또 번호는 중복되지 않은 6개여야 합니다.";
    public static final String DUPLICATED_BONUS_NUMBER_ERROR = "보너스 넘버는 로또 번호와 중복되지 않은 번호여야 합니다.";

    public LottoValidationException(String message) {
        super(ERROR_PREFIX + message);
    }
}
