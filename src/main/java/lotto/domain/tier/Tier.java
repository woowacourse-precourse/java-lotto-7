package lotto.domain.tier;

public interface Tier {
    Integer getWinningMatchCount();
    Boolean getNeedsBonusNumberMatch();
    Long getWinningAmount();
}
