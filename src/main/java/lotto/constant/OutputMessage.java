package lotto.constant;

public class OutputMessage {
    public static final int ROUND_AT = 2;
    public static final String NEW_LINE = "%n";
    public static final String LOTTO_NUMBER_DELIMITER = ", ";
    public static final String LOTTO_FORMAT = "[%s]" + NEW_LINE;
    public static final String PRIZE_FORMAT = "%s - %s개" + NEW_LINE;
    public static final String LOTTO_COUNT_FORMAT = "%d개를 구매했습니다." + NEW_LINE;
    public static final String PRIZE_START_MESSAGE = "당첨 통계" + NEW_LINE + "---" + NEW_LINE;
    public static final String EARNING_RATE_FORMAT = "총 수익률은 %." + (ROUND_AT - 1) + "f%%입니다." + NEW_LINE;
}
