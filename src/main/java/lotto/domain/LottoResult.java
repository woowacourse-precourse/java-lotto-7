package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private static final Integer MULTIPLY_PREFIX = 100;
    private final Map<LottoRank, Integer> lottoRankBoard;
    private final Integer purchaseAmount;

    public LottoResult(final Integer purchaseAmount) {
        this.lottoRankBoard = new EnumMap<>(LottoRank.class);
        this.purchaseAmount = purchaseAmount;
        init();
    }

    private void init() {
        for (LottoRank rank : LottoRank.values())
            lottoRankBoard.put(rank, 0);
    }

    public void checkLottoRank(final Lotto generatedLotto, final MyLotto myLotto) {
        Integer matchCount = myLotto.getMatchCount(generatedLotto);
        final boolean hasBonus = matchCount == 5 && myLotto.hasBonus(generatedLotto);
        updateRankCount(LottoRank.getLottoRank(matchCount, hasBonus));
    }

    private void updateRankCount(final LottoRank lottoRank) {
        lottoRankBoard.put(lottoRank, lottoRankBoard.get(lottoRank) + 1); // 해당 등수의 일치 횟수 +1
    }

    public Map<LottoRank, Integer> getLottoRankBoard() {
        return lottoRankBoard;
    }

    public double calcRateOfReturn() {
        return (double) (calcTotalPrizeMoney() * MULTIPLY_PREFIX) / purchaseAmount; // 수익률 계산
    }

    private long calcTotalPrizeMoney() {
        return lottoRankBoard.entrySet().stream()
                .mapToLong(this::calcPrizeMoneyByRank)
                .sum();
    }

    private long calcPrizeMoneyByRank(final Map.Entry<LottoRank, Integer> lottoRank) {
        return (long) lottoRank.getKey().getPrizeMoney() * lottoRank.getValue(); // 상금 * 횟수
    }
}
