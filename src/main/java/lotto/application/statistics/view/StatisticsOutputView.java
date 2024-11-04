package lotto.application.statistics.view;

import static lotto.application.statistics.domain.Rank.FIFTH;
import static lotto.application.statistics.domain.Rank.FIRST;
import static lotto.application.statistics.domain.Rank.FOURTH;
import static lotto.application.statistics.domain.Rank.SECOND;
import static lotto.application.statistics.domain.Rank.THIRD;
import static lotto.application.statistics.message.Message.DIVISION_LINE;
import static lotto.application.statistics.message.Message.PROFIT_RATE_FORMAT;
import static lotto.application.statistics.message.Message.TITLE;

import lotto.application.common.OutputPrinter;
import lotto.application.statistics.dto.StatisticsResponse;

public class StatisticsOutputView {
    private final OutputPrinter printer;

    public StatisticsOutputView() {
        this.printer = new OutputPrinter();
    }

    public void show(StatisticsResponse response) {
        appendHeader();
        appendStatistics(response);
        appendProfitRate(response);
        printer.execute();
    }

    private void appendHeader() {
        printer.appendWithLine(DIVISION_LINE);
        printer.appendWithLine(TITLE);
    }

    private void appendStatistics(StatisticsResponse response) {
        printer.appendWithLine(FIFTH.toFormattedString(response.fifthCount()));
        printer.appendWithLine(FOURTH.toFormattedString(response.fourthCount()));
        printer.appendWithLine(THIRD.toFormattedString(response.thirdCount()));
        printer.appendWithLine(SECOND.toFormattedString(response.secondCount()));
        printer.appendWithLine(FIRST.toFormattedString(response.firstCount()));
    }

    private void appendProfitRate(StatisticsResponse response) {
        printer.appendWithLine(formatProfitRate(response.profitRate()));
    }

    private String formatProfitRate(double profitRate) {
        return String.format(PROFIT_RATE_FORMAT, profitRate);
    }

}
