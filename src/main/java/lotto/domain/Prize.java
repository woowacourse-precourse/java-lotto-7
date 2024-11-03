package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;   // 일치하는 번호 개수
    private final int winnings;   // 상금
    private final boolean matchBonus;  // 보너스 번호 일치 여부

    Prize(int matchCount, int winnings, boolean matchBonus) {
        this.matchCount = matchCount;
        this.winnings = winnings;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinnings() {
        return winnings;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    // 일치하는 번호 개수와 보너스 번호 여부로 Prize 찾기
    public static Prize getPrize(int matchCount, boolean bonusMatch) {
        for (Prize prize : values()) {
            if (prize.matchCount == matchCount && prize.matchBonus == bonusMatch) {
                return prize;
            }
        }
        return NONE; // 일치하는 등수가 없을 경우 NONE 반환
    }
}
