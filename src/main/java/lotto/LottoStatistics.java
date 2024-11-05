package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private final Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);

    public LottoStatistics(LottoGame game) {
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, 0);
        }
        for (Lotto lotto : game.getPurchasedLottos()) {
            LottoRank rank = game.compareWithWinningLotto(lotto); // Compare to get rank
            results.put(rank, results.get(rank) + 1); // Increment the count for this rank
        }
    }

    public int getCount(LottoRank rank) {
        return results.getOrDefault(rank, 0);
    }

    public int getTotalPrize() {
        int total = 0;
        for (Map.Entry<LottoRank, Integer> entry : results.entrySet()) {
            total += entry.getKey().getPrizeAmount() * entry.getValue();
        }
        return total;
    }

    public double calculateYield(int purchaseAmount) {
        int totalPrize = getTotalPrize();
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    public void prettyPrintLottoStatistics(LottoGame game) {
        int totalPurchaseAmount = game.getLottoCount() * LottoRegulation.LOTTO_PRICE;
        System.out.println(MessageManager.get("message.lottostatistics.header"));
        prettyPrintEachRankStatistics();
        System.out.println(MessageManager.getFormatted(
                "message.lottostatistics.yield", calculateYield(totalPurchaseAmount)
        ));
    }

    private void prettyPrintEachRankStatistics() {
        for (LottoRank rank : LottoRank.values()) {
            String bonusBallMatch = "";
            if (rank.isMatchBonusNumber()) {
                bonusBallMatch = MessageManager.get("message.lottostatistics.bonus_match");
            }
            if (rank != LottoRank.LOTTO_RANK_NONE) {
                System.out.println(MessageManager.getFormatted(
                        "message.lottostatistics.stats_each",
                        rank.getMatchCount(),
                        bonusBallMatch,
                        rank.getPrizeAmount(),
                        getCount(rank)
                ));
            }
        }
    }
}
