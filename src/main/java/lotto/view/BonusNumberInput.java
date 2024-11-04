package lotto.view;

import static lotto.common.config.InstructionMessages.INPUT_BONUS_NUMBER;
import static lotto.common.exception.ExceptionMessages.DUPLICATED_LOTTO_NUMBER;
import static lotto.common.exception.ExceptionMessages.EMPTY_INPUT;
import static lotto.common.exception.ExceptionMessages.EMPTY_WINNING_NUMBERS;
import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.OUT_OF_LOTTO_NUMBER_RANGE;

import lotto.common.exception.EmptyInputException;
import lotto.common.exception.InvalidInputException;
import lotto.common.exception.InvalidStateException;
import lotto.common.validator.InputValidator;
import lotto.domain.Lotto;

public class BonusNumberInput implements Input<Integer, String> {
    private InputValidator inputValidator = new InputValidator(); // TODO

    @Override
    public Integer input() {
        return input(null);
    }

    public Integer input(Lotto winningNumbers) {
        Output.printMessage(INPUT_BONUS_NUMBER.getMessage());
        while (true) {
            try {
                String bonusNumber = readInput();
                validate(bonusNumber);
                validateDuplication(bonusNumber, winningNumbers);
                return Integer.valueOf(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void validate(String input) {
        if (inputValidator.isEmptyInput(input)) {
            throw new EmptyInputException(EMPTY_INPUT.getMessage());
        }
        if (!inputValidator.isNumeric(input)) {
            throw new InvalidInputException(NONE_NUMERIC_INPUT.getMessage());
        }
        if (!inputValidator.isNumberInLottoRange(input)) {
            throw new InvalidInputException(OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplication(String bonusNumber, Lotto winningNumbers) {
        if (winningNumbers == null) {
            throw new InvalidStateException(EMPTY_WINNING_NUMBERS.getMessage());
        }
        if (winningNumbers.containsNumber(Integer.parseInt(bonusNumber))) {
            throw new InvalidInputException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }
}
