package lotto.enums;

import java.util.Arrays;

public enum WinningRanking {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_MATCH_BONUS(5, 3_000_0000, true),
    SIX_MATCH(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;
    private final boolean needBonusNumber;

    WinningRanking(int matchCount, int prize) {
        this(matchCount, prize, false);
    }

    WinningRanking(int matchCount, int prize, boolean needBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.needBonusNumber = needBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean needBonusNumber() {
        return needBonusNumber;
    }

    public static WinningRanking getWinningRanking(int matchCount, boolean needBonusNumber) {
        return Arrays.stream(WinningRanking.values())
                .filter(grade -> grade.getMatchCount() == matchCount)
                .filter(grade -> grade.needBonusNumber() == needBonusNumber || !grade.needBonusNumber)
                .findFirst().orElse(null);
    }


}
