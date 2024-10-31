package lotto.model;

import lotto.utils.InputLottoNumbersValidator;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        InputLottoNumbersValidator validator = new InputLottoNumbersValidator();
        validator.validateWinningNumbers(winningNumbers);
        validator.validateBonusNumber(bonusNumber, winningNumbers);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int countNumberMatched(Lotto userLotto) {
        int matchCount = 0;
        for (int number : userLotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isBonusNumberMatched(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNumber);
    }
}
