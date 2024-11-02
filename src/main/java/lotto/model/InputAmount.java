package lotto.model;

import java.util.regex.Pattern;
import lotto.constants.ErrorMessage;

public class InputAmount {

    private static final Pattern ONLY_NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    private int inputAmount;

    public InputAmount(String inputAmount) {
        validateIsBlank(inputAmount);
    }

    private void validateIsBlank(String inputAmount) {
        if (inputAmount == null || inputAmount.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CAN_NOT_BE_BLANK.get());
        }
    }

}
