package lotto.domain;

public enum WinningRank {
    NONE(0, 0, ""),
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등;
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "); // 1등

    private static final int WINNING_MATCH_THRESHOLD = 3;
    private static final int SECOND_MATCH_COUNT = 5;
    private final int matchCount;
    private final int prizeMoney;
    private final String message;

    WinningRank(int matchCount, int prizeMoney, String message) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.message = message;
    }

    public static WinningRank getRank(int matchCount, boolean matchBonus) {
        if (WINNING_MATCH_THRESHOLD > matchCount) {
            return NONE;
        }

        if (matchCount == SECOND_MATCH_COUNT && matchBonus) {
            return SECOND;
        }

        for (WinningRank winningRank : values()) {
            if (matchCount == winningRank.matchCount) {
                return winningRank;
            }
        }

        return NONE;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getMessage() {
        return message;
    }
}
