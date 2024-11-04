package lotto.function.winning.checker.processor;

import java.util.Map;
import lotto.io.printer.prompt.PromptPrinter;
import lotto.io.printer.rank.StatisticsPrinter;
import lotto.value.Rank;

public class LottoWinningStatisticsPrintProcessor {

    private final PromptPrinter promptPrinter;
    private final StatisticsPrinter statisticsPrinter;

    public LottoWinningStatisticsPrintProcessor(PromptPrinter promptPrinter,
            StatisticsPrinter statisticsPrinter) {
        this.promptPrinter = promptPrinter;
        this.statisticsPrinter = statisticsPrinter;
    }

    public void printStatistics(Map<Rank, Integer> winningPlaces) {
        promptPrinter.printWinningStatistics();
        statisticsPrinter.printRankStatistics(winningPlaces);
    }

}
