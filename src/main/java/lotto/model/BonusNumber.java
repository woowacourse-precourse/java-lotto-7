package lotto.model;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;

public class BonusNumber {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    private final int bonusNumber;

    public BonusNumber(String rawBonusNumber) {
        validate(rawBonusNumber);
        this.bonusNumber = parseNumeric(rawBonusNumber);
    }

    public String display() {
        return String.valueOf(bonusNumber);
    }

    private void validate(String rawBonusNumber) {
        validateStrip(rawBonusNumber);
    }

    private void validateStrip(String rawBonusNumber) {
        String stripped = rawBonusNumber.strip();
        if (rawBonusNumber.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    private int parseNumeric(String rawBonusNumber) {
        try {
            int bonusNumber = Integer.parseInt(rawBonusNumber);
            validateAfterParsing(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_MUST_BE_NUMERIC);
        }
    }

    private void validateAfterParsing(int bonusNumber) {
        validateNumberInRange(bonusNumber);
    }

    private void validateNumberInRange(int bonusNumber) {
        if (isInRange(bonusNumber)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
    }

    private boolean isInRange(int bonusNumber) {
        return RANGE_START <= bonusNumber && bonusNumber <= RANGE_END;
    }
}
