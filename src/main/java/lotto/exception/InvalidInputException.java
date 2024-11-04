package lotto.exception;

public class InvalidInputException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String EMPTY_INPUT_ERROR = "공백은 입력할 수 없습니다.";
    public static final String NEGATIVE_INPUT_ERROR = "숫자는 0보다 커야 합니다.";
    public static final String NON_NUMERIC_INPUT_ERROR = "금액은 숫자만 입력 가능합니다.";
    public static final String NOT_MATCH_DELIMITER_ERROR = "번호는 ','로 구분되어야 합니다.";
    public static final String DUPLICATED_INPUT_ERROR = "로또 번호는 중복되지 않은 6개여야 합니다.";
    public static final String DUPLICATED_BONUS_NUMBER_ERROR = "보너스 넘버는 로또 번호와 중복되지 않은 번호여야 합니다.";

    public InvalidInputException(String message) {
        super(ERROR_PREFIX + message);
    }
}
