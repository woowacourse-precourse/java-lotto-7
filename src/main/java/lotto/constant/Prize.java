package lotto.constant;

import java.util.function.BiPredicate;

public enum Prize {
    FIRST((matchedCount, hasBonus) -> matchedCount == 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND((matchedCount, hasBonus) -> matchedCount == 5 && hasBonus, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD((matchedCount, hasBonus) -> matchedCount == 5 && !hasBonus, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH((matchedCount, hasBonus) -> matchedCount == 4, 50_000, "4개 일치 (50,000원) - %d개"),
    FIFTH((matchedCount, hasBonus) -> matchedCount == 3, 5_000, "3개 일치 (5,000원) - %d개"),
    NON((matchedCount, hasBonus) -> false, 0, "");

    private final BiPredicate<Integer, Boolean> condition;
    private final int prizeMoney;
    private final String resultMessage;

    Prize(BiPredicate<Integer, Boolean> condition, int prizeMoney, String resultMessage) {
        this.condition = condition;
        this.prizeMoney = prizeMoney;
        this.resultMessage = resultMessage;
    }

    public static Prize getPrize(int matchedCount, boolean hasBonus) {
        for (Prize prize : Prize.values()) {
            if (prize.matches(matchedCount, hasBonus)) {
                return prize;
            }
        }
        return NON;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    private boolean matches(int count, boolean hasBonus) {
        return condition.test(count, hasBonus);
    }
}
