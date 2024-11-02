package lotto.enums;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),  // 보너스 번호 일치 필요
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private final int matchCount;     // 당첨 번호와 일치하는 숫자 개수
    private final int prizeMoney;     // 상금
    private final boolean requiresBonus;  // 보너스 번호 일치가 필요한지 여부

    Prize(int matchCount, int prizeMoney) {
        this(matchCount, prizeMoney, false);  // 보너스 번호 불필요
    }

    Prize(int matchCount, int prizeMoney, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean requiresBonus() {
        return requiresBonus;
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
                .filter(prize -> prize.matchCount == matchCount && (!prize.requiresBonus || bonusMatch))
                .findFirst()
                .orElse(NONE);
    }
}
