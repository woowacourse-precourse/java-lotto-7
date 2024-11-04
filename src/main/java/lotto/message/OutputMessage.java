package lotto.message;

public enum OutputMessage {

    PRINT_RESULT_TITLE("당첨 통계\n---"),
    PRINT_PURCHASED_LOTTO_COUNT("%d개를 구매했습니다.\n"),
    PRINT_TOTAL_PRICE_RATE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public void printMessage(int value) {
        System.out.printf(message, value);
    }

    public void printMessage(double value) {
        System.out.printf(message, value);
    }
}
