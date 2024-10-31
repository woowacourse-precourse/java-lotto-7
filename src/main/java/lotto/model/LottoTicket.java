package lotto.model;

import static lotto.model.ErrorMessages.LottoTicket.RANK_IS_NULL;

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

    public int getProfit() {
        if (rank == null) {
            throw new IllegalArgumentException(RANK_IS_NULL);
        }

        return rank.getPrizeMoney();
    }
}
