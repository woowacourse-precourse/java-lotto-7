package lotto.domain;

import java.util.Arrays;

public enum Prize {

    FIRST(false, 6, 2_000_000_000L, 1),
    SECOND(true, 5, 30_000_000L, 2),
    THIRD(false, 5, 1_500_000L, 3),
    FOURTH(false, 4, 50_000L, 4),
    FIFTH(false, 3, 5_000L, 5),
    MISS_MATCH(false, 0, 0L, 0);

    private final int rank;
    private final Long price;
    private final int matchNumbers;
    private final boolean isMatchedBonus;

    public int getRank() {
        return rank;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public Long getPrice() {
        return price;
    }

    Prize(boolean isMatchedBonus, int matchNumbers, Long price, int rank) {
        this.isMatchedBonus = isMatchedBonus;
        this.matchNumbers = matchNumbers;
        this.price = price;
        this.rank = rank;
    }

    public static Prize inspect(WinningLotto winningLotto, Lotto lotto) {
        return Prize.of(
                winningLotto.countMatches(lotto),
                winningLotto.isMatchedBonus(lotto)
        );
    }

    public static Prize of(int matchedCount, boolean isMatchedBonus) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchNumbers == matchedCount)
                .filter(prize -> {
                    if (prize == SECOND) {
                        return isMatchedBonus;
                    }
                    return true;
                })
                .findFirst()
                .orElse(MISS_MATCH);
    }
}
