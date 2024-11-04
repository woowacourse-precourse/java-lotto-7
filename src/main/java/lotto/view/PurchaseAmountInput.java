package lotto.view;

import static lotto.common.config.InstructionMessages.INPUT_PURCHASE_AMOUNT;
import static lotto.common.exception.ExceptionMessages.EMPTY_INPUT;
import static lotto.common.exception.ExceptionMessages.NONE_NUMERIC_INPUT;
import static lotto.common.exception.ExceptionMessages.NOT_MULTIPLE_OF_UNIT_PRICE;
import static lotto.common.exception.ExceptionMessages.OUT_OF_INTEGER_RANGE;

import lotto.common.exception.EmptyInputException;
import lotto.common.exception.InvalidInputException;
import lotto.common.validator.InputValidator;

public class PurchaseAmountInput implements Input<Integer, String> {
    private InputValidator inputValidator = new InputValidator(); // TODO

    @Override
    public Integer input() {
        Output.printMessage(INPUT_PURCHASE_AMOUNT.getMessage());
        while (true) {
            try {
                String purchaseAmount = readInput();
                validate(purchaseAmount);
                return Integer.valueOf(purchaseAmount);
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
        if (!inputValidator.isIntegerRange(input)) {
            throw new InvalidInputException(OUT_OF_INTEGER_RANGE.getMessage());
        }
        if (!inputValidator.isMultipleOfUnitPrice(input)) {
            throw new InvalidInputException(NOT_MULTIPLE_OF_UNIT_PRICE.getMessage());
        }
    }
}
