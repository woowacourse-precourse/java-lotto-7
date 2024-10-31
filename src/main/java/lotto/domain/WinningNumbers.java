package lotto.domain;

import lotto.dto.WinningResult;

public class WinningNumbers {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningNumbers(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public WinningResult findWinningNumber(Lotto buyingLotto) {
        int equalCount = lotto.getEqualCount(buyingLotto);
        boolean isContainBonus = buyingLotto.isExist(bonus.getBonus());

        return new WinningResult(equalCount, isContainBonus);
    }
}
