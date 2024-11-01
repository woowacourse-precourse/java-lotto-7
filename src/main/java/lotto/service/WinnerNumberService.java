package lotto.service;

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
    }
}
