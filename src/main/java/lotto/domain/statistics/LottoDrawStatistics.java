package lotto.domain.statistics;

import java.math.BigInteger;
import lotto.domain.tier.LottoTier;
import lotto.domain.tier.Tier;

public class LottoDrawStatistics implements Statistics {
    private final Tier lottoTier;
    private Long winningLottoCount;

    private LottoDrawStatistics(Tier lottoTier, Long winningLottoCount) {
        this.lottoTier = lottoTier;
        this.winningLottoCount = winningLottoCount;
    }

    public static Statistics initStatistics(Tier lottoTier){
        return new LottoDrawStatistics(lottoTier, 0L);
    }

    @Override
    public void updateWinningLottoCount(){
        winningLottoCount++;
    }

    @Override
    public BigInteger calculateWinningAmount(){
        BigInteger tierWinningAmount = new BigInteger(lottoTier.getWinningAmount().toString());
        BigInteger winningLottoCount = new BigInteger(this.winningLottoCount.toString());
        return tierWinningAmount.multiply(winningLottoCount);
    }
    @Override
    public Long getWinningLottoCount() {
        return winningLottoCount;
    }
    @Override
    public Tier getTier(){
        return lottoTier;
    }

}
