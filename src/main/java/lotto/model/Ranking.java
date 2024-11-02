package lotto.model;

public enum Ranking {
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(30_000_000),
    THIRD_PLACE(1_500_000),
    FOURTH_PLACE(50_000),
    FIFTH_PLACE(5_000),
    LOSE(0);

    private static final int FIRST_PLACE_COUNT = 6;
    private static final int SECOND_OR_THIRD_PLACE_COUNT = 5;
    private static final int FOURTH_PLACE_COUNT = 4;
    private static final int FIFTH_PLACE_COUNT = 3;

    private int price;

    Ranking(int price) {
        this.price = price;
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
}
