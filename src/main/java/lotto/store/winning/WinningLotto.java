package lotto.store.winning;

import lotto.store.user.Lotto;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, BonusNumber bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        int count = 0;
        for (int num : lotto.getNumbers()) {
           if (winningLotto.containNumber(num)) {
               count += 1;
           }
        }

        return count;
    }

    public boolean matchBonus(int matchCount, Lotto lotto) {
        if (matchCount != 5) return false;

        for (int num : lotto.getNumbers()) {
            if (bonusNumber.equalNumber(num)) {
                return true;
            }
        }

        return false;
    }
}
