package lotto.constant;

public enum ErrorMessage {
    CAN_NOT_DIVIDE_MONEY("금액은 로또 가격 단위로 입력해주세요."),
    ONLY_NUMBER_FORMAT("금액은 숫자로만 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
