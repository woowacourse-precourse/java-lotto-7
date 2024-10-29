package lotto.constant;

public enum ErrorMessage {

    ERROR("[ERROR] "),
    PRICE_TYPE_ERROR(ERROR.getMessage() + "입력된 가격이 올바른 숫자 형식이 아닙니다."),
    PRICE_TOO_LOW_ERROR(ERROR.getMessage() + "입력된 가격이 너무 낮습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
