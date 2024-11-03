package lotto.model.win;

import java.util.List;
import lotto.util.Validator;

public class LottoWinningSet {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public LottoWinningSet(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateWinningSet(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningSet(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Validator.checkWinningSetDuplicate(winningNumbers.get(), bonusNumber.get());
    }

    public List<Integer> getWinningNumbers() {
        return List.copyOf(winningNumbers.get());
    }

    public int getBonusNumber() {
        return bonusNumber.get();
    }
}
