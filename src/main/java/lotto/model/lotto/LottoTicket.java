package lotto.model.lotto;

import static lotto.model.ErrorMessages.LottoTicket.RANK_IS_NULL;

import java.util.Map;

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
        this.rank = Rank.findRank(winningLotto.countMatchingNumberWith(lotto),
                winningLotto.isBonusNumberMatchedWith(lotto));
    }

    public int getProfit() {
        if (rank == null) {
            throw new IllegalArgumentException(RANK_IS_NULL);
        }

        return rank.getPrizeMoney();
    }

    public void countRank(Map<Rank, Integer> countRanks) {
        if (rank.equals(Rank.OUT_OF_RANK)) {
            return;
        }
        countRanks.put(rank, countRanks.getOrDefault(rank, 0) + 1);
    }
}
