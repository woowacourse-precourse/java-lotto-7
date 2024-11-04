package lotto;

import java.util.List;

public enum PrizeType {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    PrizeType(int matchCount, boolean requiresBonus, int prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static PrizeType getPrizeType(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        for (PrizeType type : PrizeType.values()) {
            if (type.matchCount == matchCount && (!type.requiresBonus || hasBonus)) {
                return type;
            }
        }
        return NONE;
    }
}
