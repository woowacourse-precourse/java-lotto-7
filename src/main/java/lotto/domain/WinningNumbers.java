package lotto.domain;

import static lotto.exception.Exception.DUPLICATED_BONUS_NUMBERS;
import static lotto.exception.Exception.LOTTO_NUMBERS_OUT_OF_RANGE;

import java.util.List;
import lotto.utils.LottoNumberValidator;

public class WinningNumbers {

    private final Lotto mainNumber;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> mainNumber, int bonusNumber) {
        validate(mainNumber, bonusNumber);
        this.mainNumber = new Lotto(mainNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean isWinningNumber(int number) {
        return mainNumber.getNumbers().contains(number);
    }

    public boolean isBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void validate(List<Integer> mainNumber, int bonusNumber) {
        validateBonusNumberIsExcluded(mainNumber, bonusNumber);
        validateBonusNumber(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!LottoNumberValidator.isWithinRange(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateBonusNumberIsExcluded(List<Integer> mainNumber, int bonusNumber) {
        if (mainNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBERS.getMessage());
        }
    }
}
