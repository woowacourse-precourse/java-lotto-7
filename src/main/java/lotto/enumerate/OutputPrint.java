package lotto.enumerate;

public enum OutputPrint {
    OUTPUT_TOTAL_EARNING_RATE("총 수익률은 %.1f%%입니다."),
    OUTPUT_BUY_QUANTITY("\n%d개를 구매했습니다."),
    OUTPUT_WIN_STRATAGE("\n당첨 통계"),
    OUTPUT_SLASH("-"),
    OUTPUT_QUANTITY("%d개");
    private final String msg;

    OutputPrint(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
