package lotto.domain.statistics;

import java.math.BigInteger;
import lotto.domain.tier.LottoTier;
import lotto.domain.tier.Tier;

public class LottoDrawStatistics implements Statistics {
    private final Tier lottoTier;
    private final Long winningLottoCount;

    private LottoDrawStatistics(Tier lottoTier, Long winningLottoCount) {
        this.lottoTier = lottoTier;
        this.winningLottoCount = winningLottoCount;
    }

    public static Statistics initStatistics(Tier lottoTier){
        return new LottoDrawStatistics(lottoTier, 0L);
    }

    //TODO: 이 부분에서 값이 바뀌면 새로운 인스턴스를 생성해서 반환해줘야 하는가, 아니면 기존 객체 데이터의 값을 변경해야 하는가...
    // 일급 컬렉션에서 List로 관리될 객체인데, List로 관리되면 값 변경이 불가능하지 않나...? 객체 생성이 맞는것 같은데..
    @Override
    public Statistics updateWinningLottoCount(Long winningLottoCount){
        return new LottoDrawStatistics(lottoTier, winningLottoCount);
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


}
