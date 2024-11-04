package lotto.function.purchase.processor;

import java.util.List;
import lotto.domain.Lotto;
import lotto.io.printer.lotto.LottoPrinter;
import lotto.io.printer.prompt.PromptPrinter;

public class LottoListPrintProcessor {

    private final PromptPrinter promptPrinter;
    private final LottoPrinter lottoPrinter;

    public LottoListPrintProcessor(PromptPrinter promptPrinter, LottoPrinter lottoPrinter) {
        this.promptPrinter = promptPrinter;
        this.lottoPrinter = lottoPrinter;
    }

    public void printLottoList(List<Lotto> lottoList) {
        promptPrinter.printPurchaseLottoCount(lottoList.size());
        lottoPrinter.printLottoList(lottoList);
    }

}
