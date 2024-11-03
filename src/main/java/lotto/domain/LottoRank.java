package lotto.domain;

import static lotto.handler.ConstantHandler.RANK_ADD_VALUE;
import static lotto.handler.ConstantHandler.RANK_DEFAULT_VALUE;

import java.util.EnumMap;
import java.util.Map;

public class LottoRank {

    private final Map<Rank, Integer> lottoRank = new EnumMap<>(Rank.class);

    public LottoRank(LottoTickets lottoTickets, WinningLotto winningLotto) {
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                lottoRank.put(rank, RANK_DEFAULT_VALUE);
            }
        }

        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Rank rank = getRank(lotto, winningLotto);
            if (rank != Rank.MISS) {
                lottoRank.put(rank, lottoRank.get(rank) + RANK_ADD_VALUE);
            }
        }
    }

    public Map<Rank, Integer> getLottoRank() {
        return lottoRank;
    }

    private Rank getRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = getMatchCount(lotto, winningLotto);
        boolean containBonusNumber = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return Rank.getRank(matchCount, containBonusNumber);
    }

    private int getMatchCount(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }
}
