package lotto.exception;

public class InvalidInputException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String EMPTY_INPUT_ERROR = "공백은 입력할 수 없습니다.";
    public static final String NEGATIVE_INPUT_ERROR = "금액은 0보다 커야 합니다.";
    public static final String NON_NUMERIC_INPUT_ERROR = "금액은 숫자만 입력 가능합니다.";
    public static final String NOT_MATCH_DELIMITER_ERROR = "번호는 ','로 구분되어야 합니다.";

    public InvalidInputException(String message) {
        super(ERROR_PREFIX + message);
    }
}
