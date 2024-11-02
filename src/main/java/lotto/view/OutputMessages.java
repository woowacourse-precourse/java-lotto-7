package lotto.view;

public enum OutputMessages {
    PAYMENT("구입금액을 입력해 주세요.");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}