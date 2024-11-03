package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankManager {

    private final static int ZERO = 0;

    private final Consumer consumer;
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
        if (!bonusInclude(matchNumbers, bonusMatch)) {
            bonusNotInclude(matchNumbers);
        }
    }

    private boolean bonusInclude(int matchNumbers, boolean bonusMatch) {
        if (matchNumbers == 5 && bonusMatch) {
            lottoRankResult.put(LottoRank.SECOND_RANK, lottoRankResult.get(LottoRank.SECOND_RANK) + 1);
            return true;
        }
        return false;
    }

    private void bonusNotInclude(int matchNumbers) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getCount() == matchNumbers && !rank.getBonus()) {
                lottoRankResult.put(rank, lottoRankResult.get(rank) + 1);
                break;
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
