package lotto.model;

public enum WinningLotto {
    THREE_MATCH("3개 일치 (5,000원) - ", 5000),
    FOUR_MATCH("4개 일치 (50,000원) - ", 50000),
    FIVE_MATCH("5개 일치 (1,500,000원) - ", 1500000),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ", 2000000000);

    private final String description;
    private final int prize;
    private int matchCount;

    WinningLotto(String description, int prize) {
        this.description = description;
        this.prize = prize;
        this.matchCount = 0;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void incrementMatchCount() {
        matchCount++;
    }

    public static void resetMatchCounts() {
        for (WinningLotto winning : WinningLotto.values()) {
            winning.matchCount = 0;
        }
    }
}
