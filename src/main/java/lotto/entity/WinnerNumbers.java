package lotto.entity;

import static lotto.exception.ExceptionUtils.throwIllegalArgument;
import static lotto.exception.WinnerNumberExceptionMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.WinnerNumberExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;

import java.util.List;
import lotto.config.LottoConfig;

public class WinnerNumbers {
    private final Lotto mainNumbers;
    private final int bonusNumber;

    public WinnerNumbers(List<Integer> mainNumbers, int bonusNumber) {
        validate(mainNumbers, bonusNumber);
        this.mainNumbers = new Lotto(mainNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> mainNumbers, int bonusNumber) {
        if (!(LottoConfig.LOTTO_MIN_NUMBER.getValue() <= bonusNumber
                && bonusNumber <= LottoConfig.LOTTO_MAX_NUMBER.getValue())) {
            throwIllegalArgument(BONUS_NUMBER_OUT_OF_RANGE);
        }
        if (mainNumbers.stream().anyMatch(number -> number == bonusNumber)) {
            throwIllegalArgument(BONUS_NUMBER_DUPLICATE);
        }
    }
}
