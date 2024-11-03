package lotto.util;

public enum ResultMessage {

    LOTTO_COUNT("%d개를 구매했습니다.\n"),

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
