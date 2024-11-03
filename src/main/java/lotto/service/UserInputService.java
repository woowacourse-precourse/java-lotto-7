package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prompter;
import lotto.domain.PurchaseAmount;

public class UserInputService {
    private final Prompter prompter;
    private final InputParser inputParser;

    public UserInputService(Prompter prompter, InputParser inputParser) {
        this.prompter = prompter;
        this.inputParser = inputParser;
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

    public Lotto createWinningNumber() {
        while (true) {
            try {
                this.prompter.showInputWinngNumberPrompt();
                String input = Console.readLine();
                List<String> winningNumbers = this.inputParser.parseWithComma(input);
                return Lotto.from(winningNumbers);
            } catch (IllegalArgumentException e){
                this.prompter.showMessage(e.getMessage());
            }
        }
    }
}
