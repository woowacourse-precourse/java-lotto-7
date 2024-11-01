package lotto.domain;

import java.util.Optional;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Optional<Ranking> calculateRanking(Lotto lotto) {
        int count = this.lotto.countCommonElements(lotto);
        return Ranking.findBy(count, lotto.contains(bonusNumber));
    }
}
