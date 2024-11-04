package lotto.enums;

import java.util.Arrays;

/**
 * class: Prize.
 *
 * 로또 당첨 등수와 상금을 관리하는 열거형
 * @author JBumLee
 * @version 2024/11/04
 */
public enum Prize {
    FIRST(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FOURTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "");

    private final int matchCount;
    private final boolean requireBonus;
    private final int prizeMoney;
    private final String description;

    /**
     * Prize enum의 생성자
     *
     * @param matchCount 당첨 번호 일치 개수
     * @param requireBonus 보너스 번호 일치 여부
     * @param prizeMoney 당첨 금액
     * @param description 당첨 내역 설명
     */
    Prize(int matchCount, boolean requireBonus, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.requireBonus = requireBonus;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    /**
     * 일치하는 번호의 개수와 보너스 번호 일치 여부로 당첨 등수를 반환한다.
     *
     * @param matchCount 일치하는 번호의 개수
     * @param hasBonus 보너스 번호 일치 여부
     * @return 당첨 등수
     */
    public static Prize valueOf(int matchCount, boolean hasBonus) {
        if (matchCount == 5 && hasBonus) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount && !prize.requireBonus)
                .findFirst()
                .orElse(NONE);
    }

    /**
     * 당첨 금액을 반환한다.
     *
     * @return 당첨 금액
     */
    public int getPrizeMoney() {
        return prizeMoney;
    }

    /**
     * 당첨 내역 설명을 반환한다.
     *
     * @return 당첨 내역 설명
     */
    public String getDescription() {
        if (this == NONE) {
            return "";
        }
        return String.format("%s (%,d원)", description, prizeMoney);
    }
}