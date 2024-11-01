package lotto.service;

import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;

import java.util.Arrays;
import lotto.constant.ExceptionMessage;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;

public class WinnerNumberService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public WinnerNumberService(InputValidator inputValidator, InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public void validate(String input) {
        inputValidator.validateInputIsEmpty(input);
        inputValidator.validateValidCharacter(input);
        String[] winnerNumbers = inputParser.parseWinnerNumber(input);
        inputValidator.validateCommaPosition(winnerNumbers);
        validateInRangeNumber(winnerNumbers);
    }

    private void validateInRangeNumber(String[] winnerNumbers) {
        boolean isValid = Arrays.stream(winnerNumbers)
                .map(Integer::parseInt)
                .allMatch(this::isInRangeNumber);

        if (!isValid) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
        }
    }

    private boolean isInRangeNumber(Integer number) {
        return number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
    }
}
