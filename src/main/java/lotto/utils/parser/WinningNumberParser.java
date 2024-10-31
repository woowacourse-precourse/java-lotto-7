package lotto.utils.parser;

import static lotto.utils.Constant.WINNING_NUMBER_INPUT_DELIMITER;
import static lotto.utils.ErrorMessage.WINNING_NUMBER_ERROR_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.validator.WinningNumberValidator;

public class WinningNumberParser {
    private final WinningNumberValidator validator;

    public WinningNumberParser(WinningNumberValidator winningNumberValidator) {
        this.validator = winningNumberValidator;
    }

    public List<Integer> parse(String userInput) {
        validator.validate(userInput);

        List<String> separatedInput = separateInput(userInput);
        List<Integer> winningNumbers = parseWinningNumbers(separatedInput);

        validator.validateNumbersCount(winningNumbers);
        validator.validateNumbersInRange(winningNumbers);
        validator.validateDuplicateNumber(winningNumbers);

        return winningNumbers;
    }

    private List<String> separateInput(String userInput) {
        return List.of(userInput.split(WINNING_NUMBER_INPUT_DELIMITER));
    }

    private List<Integer> parseWinningNumbers(List<String> separatedInput) {
        return separatedInput.stream()
                .map(this::convertToValidatedNumber)
                .collect(Collectors.toList());
    }

    private Integer convertToValidatedNumber(String input) {
        validator.validateNumber(input, WINNING_NUMBER_ERROR_MESSAGE.toString());
        return Integer.parseInt(input);
    }
}
