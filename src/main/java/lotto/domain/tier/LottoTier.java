package lotto.domain.tier;

public class LottoTier implements Tier {

    private final Integer requiredMatchCount;
    private final Boolean needsBonusNumberMatch;
    private final Long winningAmount;

    private LottoTier(Integer requiredMatchCount, Boolean needsBonusNumberMatch, Long winningAmount
    ) {
        this.requiredMatchCount = requiredMatchCount;
        this.needsBonusNumberMatch = needsBonusNumberMatch;
        this.winningAmount = winningAmount;
    }

    public static LottoTier initWinningTier(Integer winningMatchCount, Boolean needsBonusNumberMatch, Long winningAmount) {
        return new LottoTier(winningMatchCount, needsBonusNumberMatch, winningAmount);
    }

    @Override
    public Integer getRequiredMatchCount() {
        return requiredMatchCount;
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
