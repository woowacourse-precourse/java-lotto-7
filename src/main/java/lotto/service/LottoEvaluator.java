package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;

public class LottoEvaluator {

    public Map<LottoRank, Integer> evaluateLottoRankCounts(Iterable<Lotto> lottoTickets, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankCounts = initializeRankCounts();

        for (Lotto lottoTicket : lottoTickets) {
            updateRankCount(rankCounts, lottoTicket, winningLotto);
        }

        return rankCounts;
    }

    private Map<LottoRank, Integer> initializeRankCounts() {
        Map<LottoRank, Integer> rankCounts = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private void updateRankCount(Map<LottoRank, Integer> rankCounts, Lotto lottoTicket, WinningLotto winningLotto) {
        LottoRank rank = determineLottoRank(lottoTicket, winningLotto);
        rankCounts.put(rank, rankCounts.get(rank) + 1);
    }

    public LottoRank determineLottoRank(Lotto lottoTicket, WinningLotto winningLotto) {
        int matchedCount = winningLotto.countMatchingNumbers(lottoTicket);
        boolean bonusMatched = winningLotto.isBonusNumberMatched(lottoTicket);
        return LottoRank.findByMatchCountAndBonus(matchedCount, bonusMatched);
    }
}
