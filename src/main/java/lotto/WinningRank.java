package lotto;

import java.util.Arrays;

public enum WinningRank {

    First(6, 0, 2_000_000_000, "6개 일치"),
    SECOND(5, 1, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 0, 1_500_000, "5개 일치"),
    FOURTH(4, 0, 50_000, "4개 일치"),
    FIFTH(3, 0, 5_000, "3개 일치"),
    NONE(0, 0, 0, "미당첨"); // 미당첨 요구사항의 String 확인 불가.

    private final int matchCount;
    private final int bonusMatch;
    private final int prize;
    private final String description;

    WinningRank(int bonusMatch, int matchCount, int prize, String description) {
        this.bonusMatch = bonusMatch;
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static WinningRank valueOf(int matchCount, boolean matchBonus){
        if(matchCount == 5 && matchBonus){
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.bonusMatch == 0)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
