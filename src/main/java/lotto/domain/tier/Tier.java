package lotto.domain;

public interface Tier {
    Integer getWinningMatchCount();
    Boolean getNeedsBonusNumberMatch();
    Long getWinningAmount();
}
