package lotto.view.output;

public enum OutputMessage {

    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."),

    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
