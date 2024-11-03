package lotto.model;

import static lotto.constants.LottoCondition.ONE_LOTTO_TICKET_PRICE;
import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;
import static lotto.constants.ErrorMessage.AMOUNT_CAN_NOT_BE_ZERO;
import static lotto.constants.ErrorMessage.AMOUNT_CAN_NOT_HAVE_CHARACTER;
import static lotto.constants.ErrorMessage.AMOUNT_SHOULD_BE_DIVIDED_BY_THOUSAND;

import java.util.Objects;
import java.util.regex.Pattern;
import lotto.constants.ErrorMessage;

public class InputAmount {

    private static final Pattern HAS_CHARACTER_PATTERN = Pattern.compile("[^0-9]");
    private static final String AMOUNT_ZERO = "0";
    private static final int HAS_NO_REMAINDER = 0;

    private final int inputAmount;

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
            throw new IllegalArgumentException(INPUT_CAN_NOT_BE_BLANK.get());
        }
    }

    private void validateHasCharacter(String inputAmount) {
        if (HAS_CHARACTER_PATTERN.matcher(inputAmount).find()) {
            throw new IllegalArgumentException(AMOUNT_CAN_NOT_HAVE_CHARACTER.get());
        }
    }

    private void validateIsZero(String inputAmount) {
        if (inputAmount.equals(AMOUNT_ZERO)) {
            throw new IllegalArgumentException(AMOUNT_CAN_NOT_BE_ZERO.get());
        }
    }

    private void validateCanDivideByThousand(String inputAmount) {
        if (Integer.parseInt(inputAmount) % ONE_LOTTO_TICKET_PRICE.get() != HAS_NO_REMAINDER) {
            throw new IllegalArgumentException(AMOUNT_SHOULD_BE_DIVIDED_BY_THOUSAND.get());
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
