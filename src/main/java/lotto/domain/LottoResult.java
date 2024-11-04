package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);

    public LottoResult() {
        lottoResultInitialize();
    }

    private void lottoResultInitialize() {
        for(LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank != LottoRank.MISS) result.put(lottoRank, 0);
        }
    }

    public void calculateLottoResult(List<Lotto> purchasedLotteries, Numbers winNumbers, Number bonusNumber) {
        for (Lotto lotto : purchasedLotteries) {
            int lottoScore = lotto.countMatchNumbers(winNumbers);
            boolean hasBonusNumber = lotto.checkHasBonusNumber(bonusNumber);
            LottoRank rank = LottoRank.evaluate(lottoScore, hasBonusNumber);

            if (rank != LottoRank.MISS) {
                Integer rankResult = result.get(rank);
                result.put(rank, ++rankResult);
            }
        }
    }

    public float getProfitRate(Price price) {
        return ((float) calculateProfit() / price.value()) * 100;
    }

    private int calculateProfit() {
        return result.entrySet()
            .stream()
            .filter(resultEntry -> resultEntry.getValue() != 0)
            .mapToInt(resultEntry -> resultEntry.getKey().getPrize() * resultEntry.getValue())
            .sum();
    }

    public Map<LottoRank, Integer> getDetail() {
        return Collections.unmodifiableMap(result);
    }
}
