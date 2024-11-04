package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionCode;
import lotto.exception.LottoException;

public class WinningNumbers {

    private final SixNumbers sixNumbers;

    private final BonusNumber bonusNumber;

    public WinningNumbers(SixNumbers sixNumbers, BonusNumber bonusNumber) {
        this.sixNumbers = sixNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusDuplicated();
    }

    private void validateBonusDuplicated() {
        if (sixNumbers.getSixNumbers().contains(bonusNumber.getBonusNumber())) {
            throw new LottoException(ExceptionCode.DUPICATED_ERROR);
        }
    }

    public List<Integer> getSixNumbers() {
        return sixNumbers.getSixNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
