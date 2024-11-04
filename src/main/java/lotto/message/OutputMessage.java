package lotto.message;

public enum OutputMessage {

    RESULT("당첨 통계\n---"),
    ISSUED_LOTTO_COUNT("%d개를 구매했습니다."),
    TOTAL_PRICE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public void printMessage(int value) {
        System.out.printf(message, value);
        System.out.println();
    }

    public void printMessage(double value) {
        System.out.printf(message, value);
        System.out.println();
    }
}
