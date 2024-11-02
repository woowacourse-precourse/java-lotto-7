package lotto.domain;

import java.util.Optional;

public class WinningLotto {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Optional<Prize> findWinningPrize(Lotto buyingLotto) {
        int equalCount = lotto.getEqualCount(buyingLotto);
        boolean isContainBonus = buyingLotto.isExist(bonus.getBonus());

        return Prize.findPrize(equalCount, isContainBonus);
    }
}
