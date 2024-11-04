package lotto.exception;

public enum ErrorCode {

    EMPTY_INPUT("[ERROR] 빈 문자열은 입력할 수 없습니다."),
    INVALID_NUMBER_INPUT("[ERROR] 정수만 입력할 수 있습니다."),
    NOT_POSITIVE_INPUT("[ERROR] 양의 정수만 입력할 수 있습니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력할 수 있습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 입력된 번호는 1부터 45 사이여야 합니다."),
    DUPLICATE_WINNING_NUMBER("[ERROR] 중복된 숫자는 입력할 수 없습니다."),
    INVALID_WINNING_NUMBERS_INPUT("[ERROR] 6개의 숫자만 입력할 수 있습니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호가 당첨 번호와 중복될 수 없습니다."),
            ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
