package lotto.model;

import java.util.regex.Pattern;
import lotto.constants.ErrorMessage;

public class InputAmount {

    private static final Pattern HAS_CHARACTER_PATTERN = Pattern.compile("[^0-9]");

    private int inputAmount;

    public InputAmount(String inputAmount) {
        validateIsBlank(inputAmount);
        validateHasCharacter(inputAmount);
    }

    private void validateIsBlank(String inputAmount) {
        if (inputAmount == null || inputAmount.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CAN_NOT_BE_BLANK.get());
        }
    }

    private void validateHasCharacter(String inputAmount) {
        if (HAS_CHARACTER_PATTERN.matcher(inputAmount).find()) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_CAN_NOT_HAVE_CHARACTER.get());
        }
    }
}
