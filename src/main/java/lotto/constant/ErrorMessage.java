package lotto.constant;

public enum ErrorMessage {

    ERROR("[ERROR] "),
    PRICE_TYPE_ERROR(ERROR.getMessage() + "입력된 가격이 올바른 숫자 형식이 아닙니다."),
    PRICE_TOO_LOW_ERROR(ERROR.getMessage() + "입력된 가격이 너무 낮습니다."),
    PRICE_NOT_DIVISIBLE_ERROR(ERROR.getMessage() + "입력된 가격이 1000으로 나누어 떨어지지 않습니다."),
    WINNING_NUMBER_COUNT_ERROR(ERROR.getMessage() + "입력된 당첨 번호의 개수가 6개가 아닙니다."),
    WINNING_NUMBER_SIZE_ERROR(ERROR.getMessage() + "당첨 번호가 1 ~ 45 범위 내에 있지 않습니다.")
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
