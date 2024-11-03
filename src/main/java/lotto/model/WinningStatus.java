package lotto.model;

import java.util.Arrays;

public enum WinningStatus {

    THREE_MATCHES(3, 5_000, "3개 일치 (5,000원)"),
    FOUR_MATCHES(4, 50_000, "4개 일치 (50,000원)"),
    FIVE_MATCHES(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FIVE_MATCHES_WITH_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCHES(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    NO_WIN(0, 0, "");

    private final int matchCount;
    private final int prize;
    private final String description;

    WinningStatus(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static WinningStatus getWinningStatus(int matchCount, boolean isBonusMatched) {
        if(FIVE_MATCHES.getMatchCount()==matchCount && isBonusMatched) {
            return FIVE_MATCHES_WITH_BONUS;
        }
        return Arrays.stream(WinningStatus.values())
                .filter(winningStatus -> winningStatus.getMatchCount() == matchCount)
                .findFirst()
                .orElse(NO_WIN);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }
}

