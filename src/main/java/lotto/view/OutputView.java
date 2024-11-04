package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.config.SystemConstants;

public class OutputView {
    public void printLottoLogs(List<String> lottoLogs) {
        System.out.println("\n" + lottoLogs.size() + SystemConstants.OUTPUT_VIEW_PROMPT_LOTTO_LOGS);
        lottoLogs.forEach(System.out::println);
    }

    public void printWinningReport(List<String> winningReport) {
        System.out.println(SystemConstants.OUTPUT_VIEW_PROMPT_WINNING_REPORT);
        winningReport.forEach(System.out::println);
    }

    public void printProfitRate(double profitRate) {
        DecimalFormat profitRateFormat = new DecimalFormat(SystemConstants.OUTPUT_VIEW_PROMPT_PROFIT_RATE_FORMAT);
        System.out.println(SystemConstants.OUTPUT_VIEW_PROMPT_PROFIT_RATE_PREFIX +
                profitRateFormat.format(profitRate) +
                SystemConstants.OUTPUT_VIEW_PROMPT_PROFIT_RATE_SUFFIX);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
