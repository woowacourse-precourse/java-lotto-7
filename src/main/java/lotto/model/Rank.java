package lotto.model;

import java.text.NumberFormat;
import java.util.Arrays;

public enum Rank {
    FIRST_PRIZE(6, false, 2_000_000_000),
    SECOND_PRIZE(5, true, 30_000_000),
    THIRD_PRIZE(5, false, 1_500_000),
    FORTH_PRIZE(4, false, 50_000),
    FIFTH_PRIZE(3, false, 5_000);

    private final int matchCount;
    private final boolean isBonus;
    private final long prizeMoney;

    Rank(int matchCount, boolean isBonus, long prizeMoney) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank findRank(WinningLotto winningLotto, Lotto lotto) throws IllegalStateException{
        int matchCount = lotto.countMatchingNumbers(winningLotto.winningLotto());
        boolean isMatchedBonus = lotto.contains(winningLotto.bonus().bonus());
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount && rank.isBonus == isMatchedBonus)
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public String toString() {
        String formattedPrizeMoney = NumberFormat.getInstance().format(prizeMoney);
        if (isBonus) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원)", matchCount, formattedPrizeMoney);
        }
        return String.format("%d개 일치 (%s원)", matchCount, formattedPrizeMoney);
    }
}
