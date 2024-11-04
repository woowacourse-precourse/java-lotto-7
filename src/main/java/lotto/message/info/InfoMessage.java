package lotto.message.info;

public enum InfoMessage {
    REQUEST_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    RESPONSE_CNT_LOTTO("개를 구매했습니다.");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
