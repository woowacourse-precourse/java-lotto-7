package lotto.domain;

import java.util.List;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public List<Integer> getImmutableWinningNumbers() {
        return List.copyOf(winningNumbers);
    }

    public BonusNumber getImmutableBonusNumber() {
        return bonusNumber;
    }
}
