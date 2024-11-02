package lotto.constant;

public enum PrintFormattedText {
    PURCHASE_RESULT("%d개를 구매했습니다."),
    LOTT_WINNING_RESULT("%s - %d개"),
    LOTTO_EARNING_RATES("총 수익률은 %.1f%%입니다.");

    private final String format;

    PrintFormattedText(String format) {
        this.format = format;
    }

    public String format(Object args) {
        return String.format(this.format, args);
    }

    public String format(Object args1, Object args2) {
        return String.format(this.format, args1, args2);
    }
}
