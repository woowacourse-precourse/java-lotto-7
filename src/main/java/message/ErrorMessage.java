package message;

public class ErrorMessage {
    public static final String EMPTY_INPUT = "[ERROR] 입력값은 비어 있을 수 없습니다.";
    public static final String NOT_NUMERIC = "[ERROR] 입력값은 숫자여야 합니다.";
    public static final String POSITIVE_AMOUNT = "[ERROR] 입력값은 0보다 커야 합니다.";
    public static final String THOUSAND_UNIT = "[ERROR] 입력값은 1,000원 단위여야 합니다.";
    public static final String WINNING_NUMBER_FORMAT = "[ERROR] 당첨 번호는 6개의 숫자로 구성되어야 하며, 콤마로 구분되어야 합니다.";
    public static final String WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBERS = "[ERROR] 당첨 번호에는 중복된 숫자가 있을 수 없습니다.";
    public static final String BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private ErrorMessage() {}
}
