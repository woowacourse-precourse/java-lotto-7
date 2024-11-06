package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.view.Output;
import lotto.view.Prompt;
import lotto.view.Input;
import lotto.service.Validator;

public class Parser {

    private static final String DELIMITER = ",";
    private final Input input;
    private final Output output;
    private final Validator validator;

    public Parser(Input input, Output output, Validator validator) {
        this.input = input;
        this.output = output;
        this.validator = validator;
    }

    public int getPurchaseAmount() {
        int purchaseAmount;

        while (true) {
            try {
                output.printPrompt(Prompt.ENTER_PURCHASE_AMOUNT);
                purchaseAmount = Integer.parseInt(input.getInput());
                validator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                output.printErrorMessage("구입 금액은 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                output.printPrompt(Prompt.ENTER_WINNING_NUMBERS);
                String winningNumbersInput = input.getInput();
                List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);
                validator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (NumberFormatException e) {
                output.printErrorMessage("당첨 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                output.printPrompt(Prompt.ENTER_BONUS_NUMBER);
                String bonusNumberInput = input.getInput();
                int bonusNumber = Integer.parseInt(bonusNumberInput);
                validator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (NumberFormatException e) {
                output.printErrorMessage("보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                output.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) throws NumberFormatException {
        String[] numbers = input.split(DELIMITER);
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String numStr : numbers) {
            parsedNumbers.add(Integer.parseInt(numStr.trim()));
        }
        return parsedNumbers;
    }
}
