package lotto.constant;

public enum InputMessage {

    PRICE_INPUT_MESSAGE("구입금액을 입력해주세요."),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력헤 주세요.")
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
