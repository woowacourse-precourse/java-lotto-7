package lotto;

import java.util.Arrays;

public enum LottoPrize {
    JACKPOT(6, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private final int matchCount;
    private final boolean isBonusBallMatched;
    private final int money;

    public static LottoPrize of(long matchCount, boolean isBonusBallMatched) {
        return Arrays.stream(values())
                .filter(prize -> prize.isMatched(matchCount, isBonusBallMatched))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 일치하는 상금이 없습니다."));
    }

    LottoPrize(int matchCount, int money) {
        this(matchCount, false, money);
    }

    LottoPrize(int matchCount, boolean isBonusBallMatched, int money) {
        this.matchCount = matchCount;
        this.isBonusBallMatched = isBonusBallMatched;
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public boolean isMatched(long matchCount, boolean isBonusBallMatched) {
        return this.matchCount == matchCount && this.isBonusBallMatched == isBonusBallMatched;
    }
}
