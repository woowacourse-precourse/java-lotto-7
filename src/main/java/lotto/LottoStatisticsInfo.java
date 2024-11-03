package lotto;

public class LottoStatisticsInfo {
    private static final String STATISTIC_FORMAT = "%s (%,d원) - %d개";
    private final String condition;
    private final long count;
    private final int winningAmount;

    public LottoStatisticsInfo(final String condition, final int winningAmount, final long count) {
        this.condition = condition;
        this.count = count;
        this.winningAmount = winningAmount;
    }

    @Override
    public String toString() {
        return String.format(STATISTIC_FORMAT, condition, winningAmount, count);
    }
}
