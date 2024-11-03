package lotto.constant;

import java.util.Map;
import java.util.function.Function;

public enum Rank {
    FIFTH(3, 5_000, Rank::getNormalMessage),
    FOURTH(4, 50_000, Rank::getNormalMessage),
    THIRD(5, 1_500_000, Rank::getNormalMessage),
    SECOND(5, 30_000_000, Rank::getBonusMessage),
    FIRST(6, 2_000_000_000, Rank::getNormalMessage);

    private static final Map<Integer, Rank> rankMap = Map.of(
            3, FIFTH,
            4, FOURTH,
            5, THIRD,
            6, FIRST
    );;

    private final int matchCount;
    private final int prizeMoney;
    private final Function<Rank, String> messageFunction;

    Rank(int matchCount, int prizeMoney, Function<Rank, String> messageFunction) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.messageFunction = messageFunction;
    }

    public static Rank getRankByMatchCount(int matchCount) {
        return rankMap.get(matchCount);
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public String getMessage() {
        return this.messageFunction.apply(this);
    }

    private String getFormattedPrizeMoney() {
        return String.format("%,d", this.prizeMoney);
    }

    private String getNormalMessage() {
        return this.matchCount + "개 일치 (" + getFormattedPrizeMoney() + "원)";
    }

    private String getBonusMessage() {
        return this.matchCount + "개 일치, 보너스 볼 일치 (" + getFormattedPrizeMoney() + "원)";
    }
}
