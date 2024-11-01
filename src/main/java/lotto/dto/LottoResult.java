package lotto.dto;

public enum LottoResult {
    MATCH_3(3, false, 5000, "3개 일치 (5,000원)"),
    MATCH_4(4, false, 50000, "4개 일치 (50,000원)"),
    MATCH_5(5, false, 1500000, "5개 일치 (1,500,000원)"),
    MATCH_5_BONUS(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6(6, false, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final boolean bonusMatched;
    private final long prize;
    private final String message;

    LottoResult(int matchCount, boolean bonusMatched, long prize, String message) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }

    public long getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
