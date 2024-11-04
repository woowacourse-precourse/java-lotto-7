package lotto.model.constants;

public enum OutputViewConstants {
    ERROR_HEADER ("[ERROR]"),
    PURCHASE_LOTTO_NUMBER ("개를 구매했습니다."),
    LOTTO_STATICS_HEADER("당첨 통계\n---"),
    TOTAL_PROFIT_RATE_IS("총 수익률은 %.1f%%입니다."),
    PRINT_LOTTO_STAT("%s (%,d원) - %d개%n");

    private final String message;

    OutputViewConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
