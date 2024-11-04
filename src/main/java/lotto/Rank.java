package lotto;

import lotto.dto.WinningResult;

public enum Rank {
    FIRST(6, 0, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 0, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 0, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 0, 5_000, "3개 일치 (5,000원)"),
    NONE(0, 0, 0, "");

    private final int matchCount;
    private final int bonusMatchCount;
    private final int prize;
    private final String message;

    Rank(int matchCount, int bonusMatchCount, int prize, String message) {
        this.matchCount = matchCount;
        this.bonusMatchCount = bonusMatchCount;
        this.prize = prize;
        this.message = message;
    }

    public static Rank getRank(WinningResult result) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == result.getMatchCount() && rank.bonusMatchCount >= result.getBonusMatchCount()) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
