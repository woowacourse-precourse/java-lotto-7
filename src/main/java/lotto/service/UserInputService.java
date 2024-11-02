package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Prompter;
import lotto.domain.PurchaseAmount;

public class UserInputService {
    private final Prompter prompter;

    public UserInputService(Prompter prompter) {
        this.prompter = prompter;
    }

    public PurchaseAmount createPurchaseAmount() {
        while (true) {
            try {
                this.prompter.showInputPurchaseAmountPrompt();
                String input = Console.readLine();
                return PurchaseAmount.from(input);
            } catch (IllegalArgumentException e) {
                this.prompter.showMessage(e.getMessage());
            }
        }
    }

}
