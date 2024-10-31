package lotto.view;

public enum OutputMessages {
    MONEY_REQUEST("구입금액을 입력해 주세요.");

    final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
