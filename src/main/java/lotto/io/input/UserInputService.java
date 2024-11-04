package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.PurchaseAmount;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBonusNumber;
import lotto.io.output.UserPromptService;

public class UserInputService {
    private static final String COMMA_DELIMITER = ",";

    private final UserPromptService userPromptService;
    private final InputConverter inputConverter;

    public UserInputService(UserPromptService userPromptService, InputConverter inputConverter) {
        this.userPromptService = userPromptService;
        this.inputConverter = inputConverter;
    }

    public PurchaseAmount createPurchaseAmount() {
        while (true) {
            try {
                this.userPromptService.showInputPurchaseAmountPrompt();
                String input = Console.readLine();
                int value = this.inputConverter.toInteger(input);
                return new PurchaseAmount(value);
            } catch (IllegalArgumentException e) {
                this.userPromptService.showMessage(e.getMessage());
            }
        }
    }

    public Lotto createWinningNumber() {
        while (true) {
            try {
                this.userPromptService.showInputWinningNumberPrompt();
                String input = Console.readLine();
                String[] inputTokens = parseWithComma(input);
                List<Integer> winningNumbers = this.inputConverter.toIntegerList(inputTokens);
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                this.userPromptService.showMessage(e.getMessage());
            }
        }
    }

    public LottoBonusNumber createBonusNumber(Lotto winningNumber) {
        while (true) {
            try {
                this.userPromptService.showInputBonusNumberPrompt();
                String input = Console.readLine();
                int value = this.inputConverter.toInteger(input);
                return new LottoBonusNumber(winningNumber, value);
            } catch (IllegalArgumentException e) {
                this.userPromptService.showMessage(e.getMessage());
            }
        }
    }

    private String[] parseWithComma(String input) {
        return input.split(COMMA_DELIMITER);
    }
}
