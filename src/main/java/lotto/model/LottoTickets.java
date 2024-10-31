package lotto.model;

import java.math.BigInteger;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(final List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public BigInteger calculateWinningPrize(final WinningLotto winningLotto) {
        EnumMap<LottoRank, Integer> ranks = calculateAllRanks(winningLotto);
        BigInteger totalPrize = BigInteger.ZERO;
        for (Map.Entry<LottoRank, Integer> entry : ranks.entrySet()) {
            LottoRank rank = entry.getKey();
            int rankCount = entry.getValue();
            totalPrize = totalPrize.add(rank.calculatePrizeByCount(rankCount));
        }
        return totalPrize;
    }

    public EnumMap<LottoRank, Integer> calculateAllRanks(final WinningLotto winningLotto) {
        EnumMap<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : tickets) {
            LottoRank rank = winningLotto.calculateRank(lotto);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return ranks;
    }

    public int size() {
        return tickets.size();
    }
}
