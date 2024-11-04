package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    MATCH_3(3, 5000, "3개 일치"),
    MATCH_4(4, 50000, "4개 일치"),
    MATCH_5(5, 1500000, "5개 일치"),
    MATCH_5_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치"),
    MATCH_6(6, 2000000000, "6개 일치");

    private final int matchCount;
    private final int prizeMoney;
    private final String description;
    private int eachMatchCount = 0;

    private LottoPrize(final int matchCount, final int prizeMoney, final String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public int getEachMatchCount() {
        return eachMatchCount;
    }

    public void increaseEachMatchCount() {
        eachMatchCount++;
    }

    public static LottoPrize checkValue(int matchCount, boolean matchBonus){
        if(matchCount == 5 && matchBonus){
            return MATCH_5_WITH_BONUS;
        }
        return findPrizeByMatchCount(matchCount);
    }

    public static LottoPrize findPrizeByMatchCount(int matchCount){
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == matchCount && prize != MATCH_5_WITH_BONUS)
                .findFirst()
                .orElse(null);
    }


}
