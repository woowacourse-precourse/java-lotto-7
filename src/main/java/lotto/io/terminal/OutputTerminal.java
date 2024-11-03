package lotto.io.terminal;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.LottosView;
import lotto.view.StatisticView;

public class OutputTerminal {

    private static final String PURCHASED_NOTICE = "%d개를 구매했습니다.";
    private static final String STATISTIC = "당첨 통계";
    private static final String HORIZONAL_RULE = "---";
    private static final String TOTAL_RECOVERY_RATIO = "총 수익률은 %s입니다.";

    private final Writer writer;

    private OutputTerminal(final Writer writer) {
        this.writer = writer;
    }

    public static class TerminalHolder {
        private static final OutputTerminal INSTANCE = new OutputTerminal(Writer.initiate());
    }

    public static OutputTerminal getInstance() {
        return TerminalHolder.INSTANCE;
    }

    public void writeLottos(final LottosView view) {
        String message = generateFormattedMessageBy(PURCHASED_NOTICE, view.getLottoCount());

        writer.printWithNewLineBefore(message);
        writer.simplePrint(view.getLottos());
    }

    public void writeStatistics(final StatisticView view) {
        String message = generateFormattedMessageBy(TOTAL_RECOVERY_RATIO, view.getRecoveryRatio());

        writer.printWithNewLineBefore(STATISTIC);
        writer.simplePrint(HORIZONAL_RULE);
        writer.printMatchingResults(view.getMatchingResults());
        writer.simplePrint(message);

        close();
    }

    private <T> String generateFormattedMessageBy(final String message, final T source) {
        return String.format(message, source);
    }

    public void close() {
        Console.close();
    }
}
