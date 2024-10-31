package lotto.view.input;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private final String delimiter;
    private final InputValidator validator;

    public InputParser(String delimiter, InputValidator validator) {
        this.delimiter = delimiter;
        this.validator = validator;
    }

    public Integer parsePurchaseAmount(String amount) {
        Integer parsedAmount = Integer.parseInt(amount);
        validator.validateAmount(parsedAmount);

        return parsedAmount;

    }

    public List<Integer> parseWinningNumbers(String numbers) {
        List<Integer> splitNumbers = Arrays
                .stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .toList();

        validator.validateWinningNumbers(splitNumbers);
        return splitNumbers;
    }

    public Integer parseBonusNumber(String number) {
        Integer parsedNumber = Integer.parseInt(number);
        validator.validateBonusNumber(parsedNumber);
        return parsedNumber;
    }
}
