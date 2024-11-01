package lotto.service;

import static lotto.constant.Policy.WINNER_NUMBER_INPUT_REGEX;

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
        validateValidCharacter(input);
        String[] winnerNumbers = inputParser.parseWinnerNumber(input);
        validateCommaPosition(winnerNumbers);
    }

    private void validateValidCharacter(String input) {
        if (!input.matches(WINNER_NUMBER_INPUT_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNER_NUMBER_INPUT_INVALID_CHARACTER);
        }
    }

    private void validateCommaPosition(String[] winnerNumbers) {
        for (String winnerNumber : winnerNumbers) {
            if (winnerNumber.isBlank()) {
                throw new IllegalArgumentException(ExceptionMessage.WINNER_NUMBER_INVALID_COMMA_POSITION);
            }
        }
    }
}
