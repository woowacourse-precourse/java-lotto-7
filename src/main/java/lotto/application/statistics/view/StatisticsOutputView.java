package lotto.application.statistics.view;

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
        printer.execute();
    }

    private void appendHeader() {
        printer.appendLine(DIVISION_LINE);
        printer.appendLine(TITLE);
    }

}
