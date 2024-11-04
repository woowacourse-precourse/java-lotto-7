package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoPrize {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, true, 30_000_000),
    JACKPOT(6, 2_000_000_000);

    private final int matchCount;
    private final boolean isBonusBallMatched;
    private final int money;

    LottoPrize(int matchCount, int money) {
        this(matchCount, false, money);
    }

    LottoPrize(int matchCount, boolean isBonusBallMatched, int money) {
        this.matchCount = matchCount;
        this.isBonusBallMatched = isBonusBallMatched;
        this.money = money;
    }

    public static Optional<LottoPrize> of(long matchCount, boolean isBonusBallMatched) {
        return Arrays.stream(values())
                .filter(prize -> prize.isMatched(matchCount, isBonusBallMatched))
                .findAny();
    }

    public boolean isMatched(long matchCount, boolean isBonusBallMatched) {
        return this.matchCount == matchCount && this.isBonusBallMatched == isBonusBallMatched;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusBallMatched() {
        return isBonusBallMatched;
    }

    public int getMoney() {
        return money;
    }
}
