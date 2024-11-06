package lotto.model;

import static lotto.constants.ErrorMessage.BONUS_NUMBER_CANNOT_DUPLICATED_WITH_WINNING_NUMBER;
import static lotto.constants.ErrorMessage.INPUT_VALUE_MUST_BE_NUMERIC;
import static lotto.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constants.ErrorMessage.NOT_ALLOWED_BLANK_AT_EDGES;

public class BonusNumber {
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;

    private final int bonusNumber;

    public BonusNumber(String rawBonusNumber, WinningNumbers winningNumbers) {
        validate(rawBonusNumber);
        this.bonusNumber = parseNumeric(rawBonusNumber, winningNumbers);
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

    private int parseNumeric(String rawBonusNumber, WinningNumbers winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(rawBonusNumber);
            validateAfterParsing(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_MUST_BE_NUMERIC);
        }
    }

    private void validateAfterParsing(int bonusNumber, WinningNumbers winningNumbers) {
        validateNumberInRange(bonusNumber);
        validateDuplicatedWithWinningNumbers(bonusNumber, winningNumbers);
    }

    private void validateNumberInRange(int bonusNumber) {
        if (isInRange(bonusNumber)) {
            return;
        }
        throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
    }

    private void validateDuplicatedWithWinningNumbers(int bonusNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_CANNOT_DUPLICATED_WITH_WINNING_NUMBER);
        }
    }

    private boolean isInRange(int bonusNumber) {
        return RANGE_START <= bonusNumber && bonusNumber <= RANGE_END;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}