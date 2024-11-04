package lotto.service;

public enum MatchPrize {

    THREE_MATCH (3,5000),
    FOUR_MATCH (4,50000),
    FIVE_MATCH (5,1500000),
    FIVE_MATCH_WITH_BONUS (5,30000000),
    SIX_MATCH (6,2000000000);

    private final int matchCount;
    private final int prize;

    MatchPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    // matchCount에 해당하는 prize를 반환하는 메서드
    public static Integer getPrizeByMatchCount(int matchCount) {
        for (MatchPrize matchPrize : values()) {
            if (matchPrize.matchCount == matchCount) {
                return matchPrize.getPrize();
            }
        }
        return 0;
    }
}
