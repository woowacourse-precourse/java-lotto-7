package lotto.exception;

public enum ErrorCode {

    NOT_POSITIVE_INTEGER("[ERROR] 구매 금액은 양수만 입력 가능합니다."),
    NOT_DIVISIBLE_BY_THOUSAND("[ERROR] 구매 금액은 천 단위의 양수만 입력 가능합니다."),
    INVALID_WINNING_NUMBER_FORMAT("[ERROR] 당첨 번호 형식이 올바르지 않습니다."),
    INVALID_BONUS_NUMBER_FORMAT("[ERROR] 보너스 번호 형식이 올바르지 않습니다."),
    DUPLICATE_NUMBER("[ERROR] 이미 존재하는 당첨 번호입니다.");


    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
