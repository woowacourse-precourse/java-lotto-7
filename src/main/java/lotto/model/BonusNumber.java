package lotto.model;

import static lotto.constants.ErrorMessage.INPUT_CAN_NOT_BE_BLANK;
import static lotto.constants.ErrorMessage.LOTTO_CAN_NOT_HAVE_CHARACTER;
import static lotto.constants.ErrorMessage.LOTTO_NUMBER_MUST_BE_ONE_TO_FORTY_FIVE;
import static lotto.constants.LottoCondition.MIN_LOTTO_NUMBER;
import static lotto.constants.LottoCondition.MAX_LOTTO_NUMBER;

import java.util.regex.Pattern;

public class BonusNumber {

    private static final Pattern HAS_CHARACTER_PATTERN = Pattern.compile("[^0-9]");

    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(String bonusNumber) {
        validateIsBlank(bonusNumber);
        validateHasCharacter(bonusNumber);
        validateIsRangeOneToFortyFive(bonusNumber);
    }

    private void validateIsBlank(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isBlank()) {
            throw new IllegalArgumentException(INPUT_CAN_NOT_BE_BLANK.get());
        }
    }

    private void validateHasCharacter(String bonusNumber) {
        if (HAS_CHARACTER_PATTERN.matcher(bonusNumber).find()) {
            throw new IllegalArgumentException(LOTTO_CAN_NOT_HAVE_CHARACTER.get());
        }
    }

    private void validateIsRangeOneToFortyFive(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        if (number < MIN_LOTTO_NUMBER.get() || number > MAX_LOTTO_NUMBER.get()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_MUST_BE_ONE_TO_FORTY_FIVE.get());
        }
    }

}
