package lotto.model;

import java.util.Arrays;


public enum Prize {
    FIRST_PRIZE(1, 6, false, 2000000000L),
    SECOND_PRIZE(2, 5, true, 30000000L),
    THIRD_PRIZE(3, 5, false, 1500000L),
    FOURTH_PRIZE(4, 4, false, 50000L),
    FIFTH_PRIZE(5, 3, false, 5000L);
    private final Integer rank;
    private final Integer numberOfMatch;

    private final boolean isBonusMatch;
    private final Long money;

    Prize(Integer rank, Integer numberOfMatch, boolean isBonusMatch, Long money) {
        this.rank = rank;
        this.numberOfMatch = numberOfMatch;
        this.isBonusMatch = isBonusMatch;
        this.money = money;
    }

    public static Prize getMoney(int numberOfMatch, boolean isBonusMatch) {
        return Arrays.stream(Prize.values()).filter(prize ->
                        prize.isBonusMatch == isBonusMatch && prize.numberOfMatch == numberOfMatch).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 당첨되지 못 했습니다."));
    }
}
