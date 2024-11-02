package lotto.model;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class WonLotto {
    private final Lotto lotto;
    private final Rank rank;

    public WonLotto(Lotto lotto, Rank rank) {
        this.lotto = lotto;
        this.rank = rank;
    }

    public int getRankNumber() {
        return rank.getRank();
    }
    public Rank getRank() {
        return rank;
    }
}
