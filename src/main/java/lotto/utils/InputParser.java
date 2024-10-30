package lotto.utils;

import static lotto.utils.Constant.WINNING_NUMBER_INPUT_DELIMITER;
import static lotto.utils.ErrorMessage.PURCHASE_AMOUNT_ERROR_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;

public class InputParser {
    private final InputValidator inputValidator;

    public InputParser(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int parsePurchaseAmount(String userInput) {
        inputValidator.validateEmpty(userInput);
        inputValidator.validateNumber(userInput, PURCHASE_AMOUNT_ERROR_MESSAGE.toString());

        int purchaseAmount = Integer.parseInt(userInput);
        inputValidator.validateDivisibleByThousand(purchaseAmount);

        return purchaseAmount;
    }

    public void parseWinningNumbers(String userInput) {
        inputValidator.validateEmpty(userInput);
        inputValidator.validateDelimiter(userInput);

        List<String> separatedInput = separateInput(userInput);
        List<Integer> winningNumbers = parseNumbers(separatedInput);

        inputValidator.validateNumberCount(winningNumbers);
        inputValidator.validateNumberRange(winningNumbers);
        inputValidator.validateDuplicateNumber(winningNumbers);
    }

    private List<String> separateInput(String userInput) {
        return List.of(userInput.split(WINNING_NUMBER_INPUT_DELIMITER));
    }

    private List<Integer> parseNumbers(List<String> separatedInput) {
        return separatedInput.stream()
                .map(input -> {
                    inputValidator.validateNumber(input, PURCHASE_AMOUNT_ERROR_MESSAGE.toString());
                    return Integer.parseInt(input);
                })
                .collect(Collectors.toList());
    }
}
