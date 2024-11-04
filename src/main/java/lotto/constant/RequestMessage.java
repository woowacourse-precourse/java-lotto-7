package lotto.constant;

public enum RequestMessage {
    REQUEST_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_LOTTO_TICKET_NUMBER("\n당첨 번호를 입력해 주세요."),
    REQUEST_LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    RequestMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
