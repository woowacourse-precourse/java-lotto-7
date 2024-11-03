package lotto.view;

public enum OutputMessages {
    PAYMENT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_COUNT("%d개를 구매했습니다.");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}