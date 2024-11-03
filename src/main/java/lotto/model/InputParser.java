package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.util.InputValidator;
import lotto.util.message.ErrorMessage;

public class InputParser {
    private static final String SPLIT_DELIMITER = ",";
    private static final int DIVIDE_NUMBER = 1000;
    public int parsePurchaseAmount(String input) {
        try {
            InputValidator.validateNonEmpty(input);

            int purchaseAmount = Integer.parseInt(input);
            InputValidator.validatePositiveAmount(purchaseAmount);
            InputValidator.validateAmountUnit(purchaseAmount);

            return divideByThousand(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    public Lotto parseWinningNumbers(String input) {
        InputValidator.validateNoSpaces(input);

        List<Integer> winningNumbers = Arrays.stream(input.split(SPLIT_DELIMITER))
            .map(this::parseNumber)
            .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }

    public int parseBonusNumber(Lotto winningNumbers, String input) {
        int bonusNumber = parseNumber(input);
        InputValidator.validateUniqueBonus(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private int divideByThousand(int purchaseAmount) {
        return purchaseAmount / DIVIDE_NUMBER;
    }

    private int parseNumber(String input) {
        try {
            InputValidator.validateNonEmpty(input);

            int number = Integer.parseInt(input);
            InputValidator.validateNumberRange(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }
}
