package lotto.constant;

public enum ErrorMessage {

    ERROR("[ERROR] "),
    PRICE_TYPE_ERROR(ERROR.getMessage() + "입력된 가격이 올바른 숫자 형식이 아닙니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
