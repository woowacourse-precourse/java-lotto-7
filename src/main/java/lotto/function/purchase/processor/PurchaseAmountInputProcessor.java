package lotto.function.purchase.processor;

import lotto.domain.Amount;
import lotto.io.input.Input;
import lotto.io.printer.prompt.PromptPrinter;

public class PurchaseAmountInputProcessor {

    private final Input input;
    private final PromptPrinter promptPrinter;

    public PurchaseAmountInputProcessor(Input input, PromptPrinter promptPrinter) {
        this.input = input;
        this.promptPrinter = promptPrinter;
    }

    public int inputPurchaseAmount() {
        promptPrinter.printInputPurchaseAmountPrompt();
        Amount amount = new Amount(input.readLineToInteger());
        return amount.getAmount();
    }

}
