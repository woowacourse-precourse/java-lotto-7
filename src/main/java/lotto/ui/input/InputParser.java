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
        return Arrays
                .stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .toList();
    }

    public Integer parseBonusNumber(String number) {
        return Integer.parseInt(number);
    }
}
