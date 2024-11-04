package lotto.model;

import java.util.List;
import lotto.validator.LottoValidator;

public class WinnerLotto {

    private final LottoValidator validator = new LottoValidator();
    private final List<Integer> winningNumbers;
    private Integer bonusNumber;

    private WinnerLotto(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinnerLotto from(List<Integer> winningNumbers) {
        return new WinnerLotto(winningNumbers);
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validator.numberCount(winningNumbers);
        validator.duplicate(winningNumbers);
        winningNumbers.forEach(validator::numberRange);
    }

    public void setBonusNumber(int bonusNumber) {
        validator.bonusNumber(winningNumbers, bonusNumber);
        validator.numberRange(bonusNumber);
        validator.duplicate(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean hasBonus(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
