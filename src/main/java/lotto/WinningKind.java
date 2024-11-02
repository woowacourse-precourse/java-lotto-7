package lotto;

public enum WinningKind {
    MATCH_3(3, 5_000),
    MATCH_4(4, 50_000),
    MATCH_5(5, 1_500_000),
    MATCH_5_BONUS(5, 30_000_000),
    MATCH_6(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    WinningKind(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
