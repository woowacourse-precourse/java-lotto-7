package lotto.domain;

import java.util.ArrayList;
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
        if (sixNumbers.getSixNumbers().contains(bonusNumber)) {
            throw new LottoException(ExceptionCode.DUPICATED_ERROR);
        }
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>(sixNumbers.getSixNumbers());
        winningNumbers.add(bonusNumber.getBonusNumber());

        return winningNumbers;
    }
}
