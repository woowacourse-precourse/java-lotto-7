package lotto;

public enum MatchCountMessage {
    THREE_MATCH(3, "3개 일치 (5,000원) - ", 5000L),
    FOUR_MATCH(4, "4개 일치 (50,000원) - ", 50000L),
    FIVE_MATCH(5, "5개 일치 (1,500,000원) - ", 1500000L),
    FIVE_MATCH_WITH_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000L),
    SIX_MATCH(6, "6개 일치 (2,000,000,000원) - ", 2000000000L);

    private final int matchCount;
    private final String message;
    private final long prize;


    MatchCountMessage(int matchCount, String message, long prize) {
        this.matchCount = matchCount;
        this.message = message;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getMessage() {
        return message;
    }

    public long getPrize() {
        return prize;
    }

}
