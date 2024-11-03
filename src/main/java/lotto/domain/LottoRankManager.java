package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankManager {

    private final static int ZERO = 0;

    private Consumer consumer;
    private final HashMap<LottoRank, Integer> lottoRankResult = new HashMap<>();

    public LottoRankManager(Consumer consumer) {
        this.consumer = consumer;
    }

    public void initLottoRank() {
        for (LottoRank rank : LottoRank.values()) {
            lottoRankResult.put(rank, 0);
        }
    }

    public void updateLottoRank(int matchNumbers, boolean bonusMatch) {
        for (LottoRank rank : LottoRank.values()) {
            updateRanking(matchNumbers, bonusMatch, rank);
        }
    }

    private void updateRanking(int matchNumbers, boolean bonusMatch, LottoRank rank) {

        bonusInclude(matchNumbers, bonusMatch, rank);

        if (rank.getCount() == matchNumbers) {
            lottoRankResult.put(rank, lottoRankResult.get(rank) + 1);
        }
    }

    private void bonusInclude(int matchNumbers, boolean bonusMatch, LottoRank rank) {
        if (matchNumbers == 5) {
            if (rank.getCount() == matchNumbers && rank.getBonus() == bonusMatch) {
                lottoRankResult.put(rank, lottoRankResult.get(rank) + 1);
            }
        }
    }

    public HashMap<LottoRank, Integer> getLottoRankResult() {
        return lottoRankResult;
    }

    public double calculateYield() {
        long prizeSum = getPrizeSum();
        double yield = ((double) prizeSum / consumer.getMoney()) * 100;
        return Math.round(yield * 10) / 10.0;
    }

    public long getPrizeSum() {
        long sum = ZERO;
        for (Map.Entry<LottoRank, Integer> entry : lottoRankResult.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            sum += rank.getPrice() * count;
        }
        return sum;
    }
}
