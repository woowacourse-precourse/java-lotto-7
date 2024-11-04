package lotto.util;

public enum ResultMessage {

    LOTTO_COUNT("%d개를 구매했습니다.\n"),
    WINNING_STAT("당첨 통계"),
    LOTTO_STATISTICS_FORMAT("%d개 일치 (%,d원) - %d개\n"),
    LOTTO_BONUS_STATISTICS_FORMAT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    LOTTO_PROFIT_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
