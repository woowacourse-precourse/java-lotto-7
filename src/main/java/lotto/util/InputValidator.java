package lotto.util;

import static lotto.constant.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import lotto.constant.ErrorMessage;

public class InputValidator {

    private final InputParser inputParser = new InputParser();
    public void validatePurchasePrice(String purchasePrice) {
        if (purchasePrice.isEmpty())
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        if (purchasePrice.matches("[-+]?\\\\d*\\\\.?\\\\d+"))
            throw new IllegalArgumentException(INVALID_PURCHASE_PRICE.getMessage());
        int validatedPurchasePrice = inputParser.parsePurchasePrice(purchasePrice);
        if (validatedPurchasePrice < 0)
            throw new IllegalArgumentException(NEGATIVE_NUMBER.getMessage());
        if (validatedPurchasePrice % 1000 != 0)
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }

    public void validateWinningNumbers(String winningNumbers) {
        if (winningNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
        if (!isValidLottoNumbers(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
        List<Integer> parsedWinningNumbers = inputParser.parseWinningNumbers(winningNumbers);
        if (parsedWinningNumbers.size() != new HashSet<>(parsedWinningNumbers).size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXISTS.getMessage());
        }
    }

    public void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
        int parsedBonusNumber = Integer.parseInt(bonusNumber);
        if (parsedBonusNumber < 1 || parsedBonusNumber > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
        if (winningNumbers.contains(parsedBonusNumber)) {
            throw new IllegalArgumentException(ALREADY_EXISTING_NUMBER.getMessage());
        }
    }

    private boolean isValidLottoNumbers(String input) {
        String regex = "^(?:[1-9]|[1-3][0-9]|4[0-5])(,(?:[1-9]|[1-3][0-9]|4[0-5])){5}$";
        return Pattern.matches(regex, input);
    }
}
