package lotto.domain;

public class LottoTier implements Tier {

    private final Integer winningMatchCount;
    private final Boolean needsBonusNumberMatch;
    private final Long winningAmount;

    private LottoTier(Integer winningMatchCount, Boolean needsBonusNumberMatch, Long winningAmount
    ) {
        this.winningMatchCount = winningMatchCount;
        this.needsBonusNumberMatch = needsBonusNumberMatch;
        this.winningAmount = winningAmount;
    }

    public LottoTier initWinningTier(Integer winningMatchCount, Boolean needsBonusNumberMatch, Long winningAmount) {
        return new LottoTier(winningMatchCount, needsBonusNumberMatch, winningAmount);
    }

    @Override
    public Integer getWinningMatchCount() {
        return winningMatchCount;
    }

    @Override
    public Boolean getNeedsBonusNumberMatch() {
        return needsBonusNumberMatch;
    }

    @Override
    public Long getWinningAmount() {
        return winningAmount;
    }

}
