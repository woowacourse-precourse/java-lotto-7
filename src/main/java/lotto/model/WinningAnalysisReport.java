package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.WinningNumberException;

public record WinningAnalysisReport(WinningStatistics winningStatistics, ProfitRate profitRate) {

    private static final String TOTAL_PROFIT_RATE_MESSAGE = "\n총 수익률은 %.1f%%입니다.";

    public WinningAnalysisReport {
        validate(winningStatistics, profitRate);
    }

    private static void validate(WinningStatistics winningStatistics, ProfitRate profitRate) {
        if (winningStatistics == null) {
            throw new WinningNumberException(ErrorMessages.WINNING_STATISTICS_NULL);
        }
        if (profitRate == null) {
            throw new WinningNumberException(ErrorMessages.PROFIT_RATE_NULL);
        }
    }

    public static WinningAnalysisReportBuilder builder() {
        return new WinningAnalysisReportBuilder();
    }

    @Override
    public String toString() {
        return winningStatistics + String.format(TOTAL_PROFIT_RATE_MESSAGE, profitRate.getRate());
    }
}
