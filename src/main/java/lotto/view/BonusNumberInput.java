package lotto.view;

import static lotto.common.config.InstructionMessages.INPUT_BONUS_NUMBER;
import static lotto.common.exception.ExceptionMessages.EMPTY_INPUT;
import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.OUT_OF_LOTTO_NUMBER_RANGE;

import lotto.common.exception.EmptyInputException;
import lotto.common.exception.InvalidInputException;

public class BonusNumberInput implements Input<Integer, String> {
    private InputValidator inputValidator = new InputValidator(); // TODO

    @Override
    public Integer input() {
        Output.printMessage(INPUT_BONUS_NUMBER.getMessage());
        while (true) {
            try {
                String bonusNumber = readInput();
                validate(bonusNumber);
                return Integer.valueOf(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void validate(String input) {
        if (inputValidator.isEmptyInput(input)) {
            throw new EmptyInputException(EMPTY_INPUT.getMessages());
        }
        if (!inputValidator.isNumeric(input)) {
            throw new InvalidInputException(NONE_NUMERIC_INPUT.getMessages());
        }
        if (!inputValidator.isNumberInLottoRange(input)) {
            throw new InvalidInputException(OUT_OF_LOTTO_NUMBER_RANGE.getMessages());
        }
    }
}
