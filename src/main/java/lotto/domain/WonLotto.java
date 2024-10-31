package lotto.domain;

public class WonLotto {
    private final Lotto lotto;
    private final Rank rank;

    public WonLotto(Lotto lotto, Rank rank) {
        this.lotto = lotto;
        this.rank = rank;
    }

    public int getRank() {
        return rank.getRank();
    }
}
