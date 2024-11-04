package lotto.constants.messageType;

public enum InputMessageType {

    INPUT_MONEY_GUIDE_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요.");

    private final String message;

    InputMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
