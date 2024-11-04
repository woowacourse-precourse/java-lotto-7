package lotto.domain;

public enum Match {
    NO_MATCH(0),
    MATCH_3(3),
    MATCH_4(4),
    MATCH_5(5),
    MATCH_5_WITH_BONUS(6),
    MATCH_6(6);

    private final int count;

    Match(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
