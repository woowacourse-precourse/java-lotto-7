package lotto.constant;

public enum GameMessage {
    PRINT_BUYING_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PRINT_WINNING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BOUGHT_LOTTO_MESSAGE("\n%d개를 구매했습니다.\n");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public void printGameMessage() {
        System.out.println(this.message);
    }

    public void printGameMessage(Object... args) {
        System.out.printf(this.message, args);
    }
}
