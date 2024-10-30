package lotto.entity;

import static lotto.exception.ExceptionUtils.throwIllegalArgument;
import static lotto.exception.WinnerNumberExceptionMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.WinnerNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;

import java.util.List;

public class WinnerNumbers {
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinnerNumbers(List<Integer> mainNumbers, int bonusNumber) {
        this.mainNumbers = new Lotto(mainNumbers);
        this.bonusNumber = bonusNumber;
        validate(mainNumbers, bonusNumber);
    }

    private void validate(List<Integer> mainNumbers, int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throwIllegalArgument(BONUS_NUMBER_OUT_OF_RANGE);
        }
        if (mainNumbers.stream().anyMatch(number -> number == bonusNumber)) {
            throwIllegalArgument(BONUS_NUMBER_DUPLICATE);
        }
    }
}
