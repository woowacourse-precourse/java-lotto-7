package lotto.model;

public class LottoTicket {
    private final Lotto lotto;
    private Rank rank;

    public LottoTicket(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public void determineRank(WinningLotto winningLotto) {
        this.rank = Rank.findRank(lotto.countMatchingNumber(winningLotto), lotto.isBonusMatched(winningLotto));
    }
}
