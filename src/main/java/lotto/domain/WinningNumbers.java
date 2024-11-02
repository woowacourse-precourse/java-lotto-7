package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningLottoInput, int bonusNumberInput) {
        this.winningLotto = new Lotto(winningLottoInput);
        this.bonusNumber = bonusNumberInput;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
