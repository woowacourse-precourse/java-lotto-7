package lotto.function.winning.checker.processor;

import java.util.Map;
import lotto.io.printer.prompt.PromptPrinter;
import lotto.util.calculator.LottoWinningTotalReturnCalculator;
import lotto.value.Rank;

public class LottoWinningTotalReturnPrintProcessor {

    private final PromptPrinter promptPrinter;
    private final LottoWinningTotalReturnCalculator lottoWinningTotalReturnCalculator;

    public LottoWinningTotalReturnPrintProcessor(PromptPrinter promptPrinter,
            LottoWinningTotalReturnCalculator lottoWinningTotalReturnCalculator) {
        this.promptPrinter = promptPrinter;
        this.lottoWinningTotalReturnCalculator = lottoWinningTotalReturnCalculator;
    }

    public void printTotalReturn(int purchaseAmount, Map<Rank, Integer> totalRevenue) {
        double totalReturn =
                lottoWinningTotalReturnCalculator.calculateReturn(purchaseAmount, totalRevenue);
        promptPrinter.printTotalReturn(totalReturn);
    }

}
