package lotto.domain;

import java.util.List;
import lotto.dto.BonusNumber;
import lotto.dto.WinningNumbers;

public class WinningCombinations {
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningCombinations(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        if (winningNumbers.getWinningLotto().contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    public void compare(final Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int winningCount = winningNumbers.countMatchedNumbers(lottoNumbers);

    }
}

