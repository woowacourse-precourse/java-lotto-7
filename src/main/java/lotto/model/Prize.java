package lotto.model;

import java.util.Arrays;


public enum Prize {
    NO_PRIZE(Integer.MAX_VALUE, new NoRankStrategy(), 0L),
    FIFTH_PRIZE(5, new FifthRankStrategy(), 5000L),
    FOURTH_PRIZE(4, new FourthRankStrategy(), 50000L),
    THIRD_PRIZE(3, new ThirdRankStrategy(), 1500000L),
    SECOND_PRIZE(2, new SecondRankStrategy(), 30000000L),
    FIRST_PRIZE(1, new FirstRankStrategy(), 2000000000L);
    private final Integer rank;
    private LottoWinningStrategy lottoWinningStrategy;
    private final Long money;

    Prize(Integer rank, LottoWinningStrategy lottoWinningStrategy, Long money) {
        this.rank = rank;
        this.lottoWinningStrategy = lottoWinningStrategy;
        this.money = money;
    }

    public static Prize getPrize(WinningLotto winningLotto, Lotto myLotto, BonusNumber bonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.lottoWinningStrategy.isWinning(winningLotto, myLotto, bonusNumber)).findFirst()
                .orElse(Prize.NO_PRIZE);
    }

    Integer getRank() {
        return rank;
    }

    public Long getMoney() {
        return money;
    }

    public int getConditionOfMatchCount() {
        return lottoWinningStrategy.getConditionOfMatchCount();
    }

    public boolean isBonusNumberRequired() {
        return lottoWinningStrategy.isBonusNumberRequired();
    }
}
