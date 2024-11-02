package lotto.enums;

import java.util.Arrays;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;        // 당첨 번호와 일치하는 숫자 개수
    private final boolean bonusMatch;    // 보너스 번호 일치 여부
    private final int prizeMoney;        // 상금

    Prize(int matchCount, boolean bonusMatch, int prizeMoney) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    /**
     * 매칭 조건에 따라 해당하는 Prize 등수를 반환합니다.
     *
     * @param matchCount 당첨 번호와 일치하는 숫자 개수
     * @param bonusMatch 보너스 번호 일치 여부
     * @return 해당하는 Prize 등수
     */
    public static Prize valueOf(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount && prize.bonusMatch == bonusMatch)
                .findFirst()
                .orElse(NONE);
    }

}
