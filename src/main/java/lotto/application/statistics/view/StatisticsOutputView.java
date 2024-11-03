package lotto.application.statistics.view;

import static lotto.application.statistics.domain.Rank.FIFTH;
import static lotto.application.statistics.domain.Rank.FIRST;
import static lotto.application.statistics.domain.Rank.FOURTH;
import static lotto.application.statistics.domain.Rank.SECOND;
import static lotto.application.statistics.domain.Rank.THIRD;

import lotto.application.statistics.dto.StatisticsResponse;
import lotto.application.ticket.view.output.OutputPrinter;

public class StatisticsOutputView {
    private static final String DIVISION_LINE = "---";
    private static final String TITLE = "당첨 통계";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private final OutputPrinter printer;

    public StatisticsOutputView() {
        this.printer = new OutputPrinter();
    }

    public void show(StatisticsResponse response) {
        appendHeader();
        appendStatistics(response);
        printer.execute();
    }

    private void appendHeader() {
        printer.appendLine(DIVISION_LINE);
        printer.appendLine(TITLE);
    }

    private void appendStatistics(StatisticsResponse response) {
        printer.appendLine(FIFTH.toFormattedString(response.fifthCount()));
        printer.appendLine(FOURTH.toFormattedString(response.fourthCount()));
        printer.appendLine(THIRD.toFormattedString(response.thirdCount()));
        printer.appendLine(SECOND.toFormattedString(response.secondCount()));
        printer.appendLine(FIRST.toFormattedString(response.firstCount()));
    }

}
