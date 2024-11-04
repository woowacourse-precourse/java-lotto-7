package lotto.domain.model;

import lotto.domain.result.LottoStat;

public class LottoResult {
    private LottoStat lottoStat;
    private double prizeRate;

    public LottoResult(LottoStat lottoStats, double prizeRate) {
        this.lottoStat = lottoStats;
        this.prizeRate = prizeRate;
    }

    public LottoStat getLottoStat() {
        return lottoStat;
    }

    public double getPrizeRate() {
        return prizeRate;
    }
}
