package lotto.model;

import java.util.Objects;
import java.util.regex.Pattern;
import lotto.constants.ErrorMessage;

public class InputAmount {

    private static final Pattern HAS_CHARACTER_PATTERN = Pattern.compile("[^0-9]");
    private static final String AMOUNT_ZERO = "0";

    private int inputAmount;

    public InputAmount(String inputAmount) {
        validate(inputAmount);
        this.inputAmount = Integer.parseInt(inputAmount);
    }

    private void validate(String inputAmount){
        validateIsBlank(inputAmount);
        validateHasCharacter(inputAmount);
        validateIsZero(inputAmount);
        validateCanDivideByThousand(inputAmount);
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

    private void validateIsZero(String inputAmount) {
        if (inputAmount.equals(AMOUNT_ZERO)) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_CAN_NOT_BE_ZERO.get());
        }
    }

    private void validateCanDivideByThousand(String inputAmount) {
        if (Integer.parseInt(inputAmount) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_SHOULD_BE_DIVIDED_BY_THOUSAND.get());
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InputAmount comparingInputAmount = (InputAmount) obj;
        return Objects.equals(inputAmount, comparingInputAmount.inputAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputAmount);
    }

    public int get() {
        return inputAmount;
    }
}
