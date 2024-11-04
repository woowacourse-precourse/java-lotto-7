package lotto.view;

public enum OutputMessage {
    PURCHASE_PRICE_MESSAGE("구입금액을 입력해주세요."),
    PURCHASE_QUANTITY_MESSAGE("%s개를 구매했습니다."),
    WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),

    TOTAL_YIELD("총 수익률은 %.2f%%입니다.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formattedMessage(Object... args) {
        return String.format(message, args);
    }
}
