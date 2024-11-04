package lotto.domain.tier;

public interface Tier {
    Integer getRequiredMatchCount();
    Boolean getNeedsBonusNumberMatch();
    Long getWinningAmount();
}
