package lotto;

import java.text.MessageFormat;
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
        System.out.println("당첨 통계\n---");
        prettyPrintEachRankStatistics();
        System.out.println(MessageFormat.format(
                "총 수익률은 {0,number,0.0}%입니다.", calculateYield(totalPurchaseAmount)
        ));
    }

    private void prettyPrintEachRankStatistics() {
        for (LottoRank rank : LottoRank.values()) {
            String bonusBallMatch = "";
            if (rank.isMatchBonusNumber()) {
                bonusBallMatch = ", 보너스 볼 일치";
            }
            if (rank != LottoRank.LOTTO_RANK_NONE) {
                System.out.println(MessageFormat.format(
                        "{0}개 일치{1} ({2}원) - {3}개",
                        rank.getMatchCount(),
                        bonusBallMatch,
                        rank.getPrizeAmount(),
                        getCount(rank)
                ));
            }
        }
    }
}
