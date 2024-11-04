package lotto.application.model;

import static lotto.common.Consts.FIFTH_PRIZE_MONEY;
import static lotto.common.Consts.FIRST_PRIZE_MONEY;
import static lotto.common.Consts.FOURTH_PRIZE_MONEY;
import static lotto.common.Consts.SECOND_PRIZE_MONEY;
import static lotto.common.Consts.THIRD_PRIZE_MONEY;

import java.util.Arrays;

public enum WinningRanking implements Model{

    FIRST(6,false, FIRST_PRIZE_MONEY),
    SECOND(5,true, SECOND_PRIZE_MONEY),
    THIRD(5,false, THIRD_PRIZE_MONEY),
    FOURTH(4,false, FOURTH_PRIZE_MONEY),
    FIFTH(3,false, FIFTH_PRIZE_MONEY),
    NON_MATCH(0,false,0);

    private int matchedCount;
    private boolean isBonusMatched;
    private int prizeMoney;

    WinningRanking(int matchedCount, boolean isBonusMatched, int prizeMoney) {
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.prizeMoney = prizeMoney;
    }

    @Override
    public String toString(){
        return this.isBonusMatched + "" + this.matchedCount + this.prizeMoney;
    }

    public static WinningRanking findWinningRankingByMatchedCount(int matchedCount) {
        return Arrays.stream(WinningRanking.values())
                .filter(winningRanking -> {
                    if(winningRanking.matchedCount==matchedCount) return true;
                    return false;
                })
                .findFirst()
                .orElse(WinningRanking.NON_MATCH);
    }

}
