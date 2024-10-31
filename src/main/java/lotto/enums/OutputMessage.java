package lotto.enums;

public enum OutputMessage implements MessageProvider {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

