package lotto.constant;

public enum PrintFormattedText {
    PURCHASE_RESULT("%d개를 구매했습니다.");

    private final String format;

    PrintFormattedText(String format) {
        this.format = format;
    }

    public String format(Object args) {
        return String.format(this.format, args);
    }
}
