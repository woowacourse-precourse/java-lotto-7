package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.util.InputValidator;
import lotto.util.message.ErrorMessage;

public class InputParser {
    public int parsePurchaseAmount(String input) {
        try {
            int purchaseAmount = Integer.parseInt(input);
            InputValidator.validateNonNegativeAmount(purchaseAmount);
            InputValidator.validateAmountUnit(purchaseAmount);
            return divideByThousand(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    public Lotto parseWinningNumbers(String input) {
        InputValidator.validateNonEmpty(input);
        InputValidator.validateNoSpaces(input);
        List<Integer> winningNumbers = Arrays.stream(input.split(","))
            .map(this::parseNumber)
            .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }

    public int parseNumber(String number) {
        try {
            int winningNumber = Integer.parseInt(number);
            InputValidator.validateNumberRange(winningNumber);
            return winningNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR);
        }
    }

    private int divideByThousand(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
