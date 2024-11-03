package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class UserInputService {
    private final Prompter prompter;
    private final InputConverter inputConverter;

    public UserInputService(Prompter prompter, InputConverter inputConverter) {
        this.prompter = prompter;
        this.inputConverter = inputConverter;
    }

    public PurchaseAmount createPurchaseAmount() {
        while (true) {
            try {
                this.prompter.showInputPurchaseAmountPrompt();
                String input = Console.readLine();
                int value = this.inputConverter.toInteger(input);
                return new PurchaseAmount(value);
            } catch (IllegalArgumentException e) {
                this.prompter.showMessage(e.getMessage());
            }
        }
    }

    public Lotto createWinningNumber() {
        while (true) {
            try {
                this.prompter.showInputWinningNumberPrompt();
                String input = Console.readLine();
                String[] inputTokens = parseWithComma(input);
                List<Integer> winningNumbers = this.inputConverter.toIntegerList(inputTokens);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                this.prompter.showMessage(e.getMessage());
            }
        }
    }

    public BonusNumber createBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                this.prompter.showInputBonusNumberPrompt();
                String input = Console.readLine();
                int value = this.inputConverter.toInteger(input);
                return new BonusNumber(winningNumber, value);
            } catch (IllegalArgumentException e) {
                this.prompter.showMessage(e.getMessage());
            }
        }
    }

    private String[] parseWithComma(String input) {
        return input.split(",");
    }
}
