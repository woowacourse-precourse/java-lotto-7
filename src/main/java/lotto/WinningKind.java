package lotto;

import java.util.Arrays;

public enum WinningKind {
    MATCH_3(3, false, 5_000),
    MATCH_4(4, false, 50_000),
    MATCH_5(5, false, 1_500_000),
    MATCH_5_BONUS(5, true, 30_000_000),
    MATCH_6(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean bonus;
    private final int prize;

    WinningKind(int matchCount, boolean bonus, int prize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningKind getWinningKind(int matchCount, boolean bonus) {
        if (matchCount != 5) return Arrays.stream(WinningKind.values())
                                    .filter(kind -> kind.matchCount == matchCount)
                                    .findFirst()
                                    .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 조건에 맞는 당첨 종류가 없습니다."));

        if (bonus) return MATCH_5_BONUS;
        return MATCH_5;
    }

}
