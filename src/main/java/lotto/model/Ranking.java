package lotto.model;

import java.util.List;

public enum Ranking {
    FIRST_PLACE(2_000_000_000, 6, false),
    SECOND_PLACE(30_000_000, 5, true),
    THIRD_PLACE(1_500_000, 5, false),
    FOURTH_PLACE(50_000, 4, false),
    FIFTH_PLACE(5_000, 3, false),
    LOSE(0, 0, false);

    private static final int FIRST_PLACE_COUNT = 6;
    private static final int SECOND_OR_THIRD_PLACE_COUNT = 5;
    private static final int FOURTH_PLACE_COUNT = 4;
    private static final int FIFTH_PLACE_COUNT = 3;

    private final int price;
    private final int matchingCount;
    private final boolean isBonusNumberMatching;

    Ranking(int price, int matchingCount, boolean isBonusNumberMatching) {
        this.price = price;
        this.matchingCount = matchingCount;
        this.isBonusNumberMatching = isBonusNumberMatching;
    }

    public static Ranking of(int matchingCount, boolean isBonusNumberMatching) {
        if (matchingCount == FIRST_PLACE_COUNT) {
            return FIRST_PLACE;
        }
        if (matchingCount == SECOND_OR_THIRD_PLACE_COUNT && isBonusNumberMatching) {
            return SECOND_PLACE;
        }
        if (matchingCount == SECOND_OR_THIRD_PLACE_COUNT) {
            return THIRD_PLACE;
        }
        if (matchingCount == FOURTH_PLACE_COUNT) {
            return FOURTH_PLACE;
        }
        if (matchingCount == FIFTH_PLACE_COUNT) {
            return FIFTH_PLACE;
        }
        return LOSE;
    }

    public static List<Ranking> winnerValuesOrderByRankDesc() {
        return List.of(
                FIFTH_PLACE, FOURTH_PLACE, THIRD_PLACE, SECOND_PLACE, FIRST_PLACE
        );
    }

    public int getPrice() {
        return price;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonusNumberMatching() {
        return isBonusNumberMatching;
    }
}
