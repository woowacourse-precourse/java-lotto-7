package lotto.model;

import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;

public class BonusNumber {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    private final String rawBonusNumber;

    public BonusNumber(String rawBonusNumber) {
        validate(rawBonusNumber);
        this.rawBonusNumber = rawBonusNumber;
    }

    private void validate(String rawBonusNumber) {
        validateStrip(rawBonusNumber);
        validateNumeric(rawBonusNumber);
        validateNumberInRange(rawBonusNumber);
    }

    private void validateStrip(String rawBonusNumber) {
        String stripped = rawBonusNumber.strip();
        if (rawBonusNumber.equals(stripped)) {
            return;
        }
        throw new IllegalArgumentException(NOT_ALLOWED_BLANK_AT_EDGES);
    }

    private void validateNumeric(String rawBonusNumber) {
        try {
            Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_MUST_BE_NUMERIC);
        }
    }

    private void validateNumberInRange(String rawBonusNumber) {
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        if (isInRange(bonusNumber)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
    }

    private boolean isInRange(int bonusNumber) {
        return RANGE_START <= bonusNumber && bonusNumber <= RANGE_END;
    }
}
