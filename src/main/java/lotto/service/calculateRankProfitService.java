package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.constants.Rank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchasedLottos;

public class calculateRankProfitService {

    private final Map<Rank, Integer> rankingCount = new EnumMap<>(Rank.class);

    public calculateRankProfitService() {
        for (Rank rank : Rank.values()) {
            rankingCount.put(rank, 0);
        }
    }

    public void countRank(PurchasedLottos lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        for (Lotto nowTicket : lottos.get()) {
            int matchingCount = compareLottos(nowTicket, winningLotto);
            boolean checkBonus = hasBonus(nowTicket, bonusNumber);
            updateRankCount(matchingCount, checkBonus);
        }
    }

    private int compareLottos(Lotto nowTicket, Lotto winningTicket) {
        return (int) nowTicket.get().stream()
                .filter(winningTicket.get()::contains)
                .distinct()
                .count();
    }

    private boolean hasBonus(Lotto nowTicket, BonusNumber bonusNumber) {
        return nowTicket.get().contains(bonusNumber.get());
    }

    private void updateRankCount(int matchingCount, boolean checkBonus) {
        Rank rank = Rank.of(matchingCount, checkBonus);
        if (rank == null) {
            return;
        }
        rankingCount.put(rank, rankingCount.get(rank) + 1);
    }

    public long getProfit() {
        long sum = 0;
        for (Rank rank : Rank.values()) {
            sum += rankingCount.get(rank) * rank.getWinningPrice();
        }
        return sum;
    }

    public Map<Rank, Integer> getRankingCount() {
        return rankingCount;
    }
}
