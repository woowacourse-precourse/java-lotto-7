package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = Lotto.from(winningNumbers);
        this.bonusNumber = BonusNumber.from(bonusNumber);
    }

    public static WinningLotto of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
