package lotto.enums;

public enum Rank {
    ZERO(0, 0, false, "0"),
    ONE(1, 6, false, "2,000,000,000"),
    TWO(2, 5, true, "30,000,000"),
    THREE(3, 5, false, "1,500,000"),
    FOUR(4, 4, false, "50,000"),
    FIVE(5, 3, false, "5,000"),
    ;

    private static final String SEPARATOR = ",";
    private static final String EMPTY = "";

    private final int value;
    private final int matchCount;
    private final boolean isBonusMatch;
    private final String reword;

    Rank(int value, int matchCount, boolean isBonusMatch, String reword) {
        this.value = value;
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.reword = reword;
    }

    public static Rank getRankByResult(int matchCount, boolean isBonusMatch) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.isBonusMatch == isBonusMatch) {
                return rank;
            }
        }
        return ZERO;
    }

    public static Rank getRankByValue(int value) {
        for (Rank rank : Rank.values()) {
            if (rank.value == value) {
                return rank;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public String getReword() {
        return reword;
    }

    public int getRewordValue() {
        return Integer.parseInt(this.reword.replace(SEPARATOR, EMPTY));
    }
}
