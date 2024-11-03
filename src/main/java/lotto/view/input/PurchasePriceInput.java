package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class PurchasePriceInput {

    private final PromptDisplayer promptDisplayer;

    public PurchasePriceInput(PromptDisplayer promptDisplayer) {
        this.promptDisplayer = promptDisplayer;
    }

    public String getPurchasePrice() {
        promptDisplayer.showPurchasePrompt();
        return Console.readLine();
    }
}
