package lotto.util.message;

public final class OutputMessage {

    public static final String OUTPUT_PURCHASED_LOTTO_COUNT = "\n%,d개를 구매했습니다.\n";
    public static final String OUTPUT_WINNING_STATISTIC_TITLE = "\n당첨 통계\n---";
    public static final String OUTPUT_SAME_LOTTO_NUMBER_COUNT = "%d개 일치";
    public static final String OUTPUT_BONUS_NUMBER_SAME = ", 보너스 볼 일치";
    public static final String OUTPUT_REWARDS_AND_LOTTO_COUNT = " (%,d원) - %,d개\n";
    public static final String OUTPUT_TOTAL_PROFIT_PERCENTAGE = "총 수익률은 %,.1f%%입니다.\n";

    public static final String ERROR_MESSAGE = "[ERROR]";

    private OutputMessage() {
    }
}
