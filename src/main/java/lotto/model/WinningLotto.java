package lotto.model;

import java.util.List;
import lotto.util.Config;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    private void validateBonusNumber() {
        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Config.ERROR_BONUS_NUMBER_DUPLICATE);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
