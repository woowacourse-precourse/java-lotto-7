package lotto.constant;

public enum GameMessage {
    PRINT_BUYING_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    PRINT_WINNING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요."),
    PRINT_BONUS_NUMBERS_MESSAGE("\n보너스 번호를 입력해 주세요."),
    PRINT_BOUGHT_LOTTO_MESSAGE("\n%d개를 구매했습니다.\n"),
    PRINT_WINNING_STATISTIC_MESSAGE("\n당첨 통계\n---"),
    PRINT_HOW_MANY_WINNING_MESSAGE("%d개 일치%s (%s원) - %d개\n"),
    PRINT_PROFIT_RATE_MESSAGE("\n총 수익률은 %.1f%%입니다."),
    BONUS_LOTTO_MESSAGE(", 보너스 볼 일치");

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

    public String getMessage() {
        return message;
    }
}
