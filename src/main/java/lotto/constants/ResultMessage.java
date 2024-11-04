package lotto.constants;

public enum ResultMessage {
    PURCHASED_LOTTO("%d개를 구매했습니다."),
    WIN_RESULT("당첨 통계\n---"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;
    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public String getIntMessage(int place) {
        return String.format(message, place);
    }
    public String getProfitRateMessage(double rate) {
        return String.format(message, rate);
    }
}
