package lotto.utils;

import static lotto.utils.Constant.WINNING_NUMBER_INPUT_DELIMITER;
import static lotto.utils.ErrorMessage.WINNING_NUMBER_ERROR_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.validator.BonusNumberValidator;
import lotto.utils.validator.PurchaseAmountValidator;
import lotto.utils.validator.WinningNumberValidator;

public class InputParser {
    private final PurchaseAmountValidator purchaseAmountValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final WinningNumberValidator winningNumberValidator;

    public InputParser(
            PurchaseAmountValidator purchaseAmountValidator,
            WinningNumberValidator winningNumberValidator,
            BonusNumberValidator bonusNumberValidator
    ) {
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.winningNumberValidator = winningNumberValidator;
        this.bonusNumberValidator = bonusNumberValidator;
    }

    public int parsePurchaseAmount(String userInput) {
        purchaseAmountValidator.validate(userInput);

        int purchaseAmount = parseNumber(userInput);
        purchaseAmountValidator.validateDivisibleByThousand(purchaseAmount);

        return purchaseAmount;
    }

    public List<Integer> parseWinningNumbers(String userInput) {
        winningNumberValidator.validate(userInput);

        List<String> separatedInput = separateInput(userInput);
        List<Integer> winningNumbers = parseWinningNumbers(separatedInput);

        winningNumberValidator.validateNumbersCount(winningNumbers);
        winningNumberValidator.validateNumbersInRange(winningNumbers);
        winningNumberValidator.validateDuplicateNumber(winningNumbers);

        return winningNumbers;
    }

    public int parseBonusNumber(String userInput, List<Integer> winningNumbers) {
        bonusNumberValidator.validate(userInput);

        int bonusNumber = parseNumber(userInput);
        bonusNumberValidator.validateNumberInRange(bonusNumber);
        bonusNumberValidator.validateDuplicateBonusNumber(bonusNumber, winningNumbers);

        return bonusNumber;
    }

    private int parseNumber(String userInput) {
        return Integer.parseInt(userInput);
    }

    private List<String> separateInput(String userInput) {
        return List.of(userInput.split(WINNING_NUMBER_INPUT_DELIMITER));
    }

    private List<Integer> parseWinningNumbers(List<String> separatedInput) {
        return separatedInput.stream()
                .map(this::parseAndValidateWinningNumber)
                .collect(Collectors.toList());
    }

    private Integer parseAndValidateWinningNumber(String input) {
        winningNumberValidator.validateNumber(input, WINNING_NUMBER_ERROR_MESSAGE.toString());
        return Integer.parseInt(input);
    }
}
