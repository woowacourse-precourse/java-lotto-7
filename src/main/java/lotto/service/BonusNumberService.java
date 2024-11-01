package lotto.service;

import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;

import lotto.constant.ExceptionMessage;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;

public class BonusNumberService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;

    public BonusNumberService(InputValidator inputValidator, InputParser inputParser) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
    }

    public void validate(String input) {
        inputValidator.validateInputIsEmpty(input);
        Integer bonusNumber = inputParser.parseBonusAmount(input);
        validateInRangeNumber(bonusNumber);
    }

    private void validateInRangeNumber(Integer bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_NUMBER_INVALID_RANGE);
        }
    }
}
