package lotto.io.printer.prompt;

public interface PromptPrinter {

    void printInputPurchaseAmountPrompt();

    void printPurchaseLottoCount(int lottoCount);

    void printInputLottoWinningNumbers();

    void printInputLottoBonusNumber();

    void printWinningStatistics();

    void printTotalReturn(double totalReturn);
}
