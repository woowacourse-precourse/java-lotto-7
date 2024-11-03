package lotto.constants;

public enum WinRank {
    // 순위
    FIRST(6),
    SECOND(5),
    THIRD(5),
    FOURTH(4),
    FIFTH(3),
    ETC(0)
    ;

    private final int matchCount;

    WinRank(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
