package lotto.model.lotto;

import static lotto.common.Error.NOT_DUPLICATED_NUMBER;
import static lotto.common.Error.OUT_OF_RANGE;
import static lotto.common.Rule.MAXIMUM_RANGE_NUMBER;
import static lotto.common.Rule.MINIMUM_RANGE_NUMBER;

public record Bonus(int number) {

    public static Bonus from(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplication(lotto, bonusNumber);
        return new Bonus(bonusNumber);
    }

    private static void validateRange(int number) {
        if (number < MINIMUM_RANGE_NUMBER.getNumber() || number > MAXIMUM_RANGE_NUMBER.getNumber()) {
            throw new IllegalArgumentException(OUT_OF_RANGE.getMessage());
        }
    }

    private static void validateDuplication(Lotto lotto, int bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(NOT_DUPLICATED_NUMBER.getMessage());
        }
    }
}
