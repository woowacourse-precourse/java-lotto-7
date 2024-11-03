package lotto.constant;

public class OutputMessages {
    public static final String LOTTO_BUY_COUNT_MESSAGE = "%d개를 구매했습니다.";
    public static final String OUTPUT_DELIMITER = ", ";
    public static final String PREFIX = "[";
    public static final String SUFFIX = "]";
    public static final String RESULT_MESSAGE = "당첨 통계\n---";
    public static final String MATCH_COUNT_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String MATCH_COUNT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String WINNINGS_FORMAT = "%,d";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.%n";

    private OutputMessages() {
    }
}
