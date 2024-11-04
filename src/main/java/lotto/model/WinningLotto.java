package lotto.model;

public enum WinningLotto {
    THREE_MATCH("3개 일치 (5,000원) - ", 0),
    FOUR_MATCH("4개 일치 (50,000원) - ", 0),
    FIVE_MATCH("5개 일치 (1,500,000원) - ", 0),
    FIVE_MATCH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 0),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ", 0);

    private final String description;
    private int matchCount;

    WinningLotto(String description, int matchCount) {
        this.description = description;
        this.matchCount = matchCount;
    }

    public String getDescription() {
        return description;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void incrementMatchCount() {
        matchCount++;
    }
}
