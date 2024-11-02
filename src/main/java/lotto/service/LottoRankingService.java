package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Rank;

public class LottoRankingService {

    public static EnumMap<Rank, Integer> calculateLottoRank(Lotto lotto, ArrayList<List<Integer>> purchasedLottoNumbers, BonusNumber bonusNumber) {
        EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        purchasedLottoNumbers.forEach(purchasedLottoNumber -> {
            Rank rank = determineRank(countMatches(lotto, purchasedLottoNumber), purchasedLottoNumber.contains(bonusNumber.getBonusNumber()));
            if (rank != null) {
                rankCounts.put(rank, rankCounts.get(rank) + 1);
            }
        });
        return rankCounts;
    }

    public static int countMatches(Lotto lotto, List<Integer> purchasedLottoNumber) {
        return (int) purchasedLottoNumber.stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    private static Rank determineRank(int matchCount, boolean hasBonus) {
        if (matchCount == Rank.FIRST.getMatchCount()) return Rank.FIRST;
        if (matchCount == Rank.SECOND.getMatchCount() && hasBonus) return Rank.SECOND;
        if (matchCount == Rank.THIRD.getMatchCount() && !hasBonus) return Rank.THIRD;
        if (matchCount == Rank.FOURTH.getMatchCount()) return Rank.FOURTH;
        if (matchCount == Rank.FIFTH.getMatchCount()) return Rank.FIFTH;
        return null;
    }

    public static double getTotalRate(EnumMap<Rank, Integer> rankCounts, int money) {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return Math.round((double) totalPrize / money * 1000) / 10.0;
    }
}
