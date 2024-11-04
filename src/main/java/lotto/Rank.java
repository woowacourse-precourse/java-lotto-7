package lotto;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FIRST(6, false, 2_000_000_000);

    private final int matchNumber;
    private final boolean matchBonus;
    private final int prize;

    Rank(int matchNumber, boolean matchBonus, int prize) {
        this.matchNumber = matchNumber;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank getRank(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchNumber == matchCount && rank.matchBonus == hasBonus)
            .findFirst()
            .orElse(null);
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }
}
