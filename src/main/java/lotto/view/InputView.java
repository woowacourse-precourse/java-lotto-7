package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.parser.InputParser;
import lotto.validation.InputValidator;

import java.util.List;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();

    public int getPurchaseAmount() {
        String input = Console.readLine();
        inputValidator.validateNotEmpty(input);
        int purchaseAmount = inputParser.parseToInt(input);
        inputValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        inputValidator.validateNotEmpty(input);
        inputValidator.checkDelimiter(input);
        List<Integer> winningNumbers = inputParser.parseToIntegerList(input);
        inputValidator.foundDuplicateNumber(winningNumbers);
        return winningNumbers;
    }

    public int getBonusNumber() {
        String input = Console.readLine();
        inputValidator.validateNotEmpty(input);
        int bonusNumber = inputParser.parseToInt(input);
        inputValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }
}