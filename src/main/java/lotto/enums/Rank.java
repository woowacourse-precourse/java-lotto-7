package lotto.enums;

public enum Rank {
    FIRST_PLACE_MATCH_COUNT(6),
    SECOND_PLACE_MATCH_COUNT(5),
    THIRD_PLACE_MATCH_COUNT(5),
    FOURTH_PLACE_MATCH_COUNT(4),
    FIFTH_PLACE_MATCH_COUNT(3),
    FIRST_PLACE_INDEX(0),
    SECOND_PLACE_INDEX(1),
    THIRD_PLACE_INDEX(2),
    FOURTH_PLACE_INDEX(3),
    FIFTH_PLACE_INDEX(4);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
