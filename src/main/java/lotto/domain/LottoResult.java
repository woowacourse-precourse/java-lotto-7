package lotto.domain;

import java.util.Map;

public class LottoResult {
    private static final int PERCENTAGE = 100;
    private Map<LottoRank, Integer> lottoResultForm;

    public LottoResult(Map<LottoRank, Integer> lottoResultForm) {
        this.lottoResultForm = lottoResultForm;
    }

    public void addCountByLottoRank(LottoRank lottoRank) {
        lottoResultForm.put(lottoRank, lottoResultForm.get(lottoRank) + 1);
    }

    public double getTotalProfit() {
        int purchaseCost = LottoOption.PUCHASE_MONEY_UNIT * getTotalCount();
        double totalPrize = getTotalPrize();
        return (totalPrize / purchaseCost) * PERCENTAGE;
    }

    public int getTotalCount() {
        return lottoResultForm.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private double getTotalPrize() {
        return lottoResultForm.keySet()
                .stream()
                .mapToDouble(rank -> rank.getPrize() * lottoResultForm.get(rank))
                .sum();
    }
}