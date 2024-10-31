package lotto.constant;

public enum ErrorMessage {
    CAN_NOT_DIVIDE_MONEY("금액은 로또 가격 단위로 입력해주세요."),
    ONLY_NUMBER_FORMAT("숫자로만 입력해주세요."),
    NOT_MATCHED_WINNING_NUMBER_COUNT("당첨 번호는 %d개 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
