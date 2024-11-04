package lotto;

public enum LottoRank {
    THREE_MATCH(3, 5000),          // 3개 일치
    FOUR_MATCH(4, 50000),          // 4개 일치
    FIVE_MATCH(5, 1500000),        // 5개 일치
    FIVE_MATCH_BONUS(5, 30000000), // 5개 + 보너스
    SIX_MATCH(6, 2000000000);     // 6개 일치

    private final int prize;
    private final int matchCount;
    private int count;

    LottoRank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.count = 0; // 초기 카운트는 0
    }

    public int getPrize() {
        return prize;
    }

    public int getCount() {
        return count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void incrementCount() {
        this.count++;
    }
}

