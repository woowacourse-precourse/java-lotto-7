package lotto.io.printer.prompt;

import lotto.io.printer.StringPrinter;

public class ConsolePromptPrinter implements PromptPrinter {

    private final StringPrinter stringPrinter;

    public ConsolePromptPrinter(StringPrinter stringPrinter) {
        this.stringPrinter = stringPrinter;
    }

    @Override
    public void printInputPurchaseAmountPrompt() {
        stringPrinter.printString(Prompt.INPUT_PURCHASE_AMOUNT.toString());
    }

    @Override
    public void printPurchaseLottoCount(int lottoCount) {
        stringPrinter.printString(Prompt.PRINT_PURCHASE_LOTTO_COUNT.format(lottoCount));
    }

    @Override
    public void printInputLottoWinningNumbers() {
        stringPrinter.printString(Prompt.INPUT_LOTTO_WINNING_NUMBERS.toString());
    }

    @Override
    public void printInputLottoBonusNumber() {
        stringPrinter.printString(Prompt.INPUT_LOTTO_BONUS_NUMBER.toString());
    }

    @Override
    public void printWinningStatistics() {
        stringPrinter.printString(Prompt.WINNING_STATISTICS.toString());
    }

    @Override
    public void printTotalReturn(double totalReturn) {
        stringPrinter.printString(Prompt.TOTAL_RETURN.format(totalReturn));
    }

}
