package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean needBonusMatch;

    Rank(int matchCount, int prize, boolean needBonusMatch) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.needBonusMatch = needBonusMatch;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && !rank.needBonusMatch) {
                return rank;
            }
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        if (this == NONE) {
            return "미당첨";
        }

        String description = String.format("%d개 일치", matchCount);
        if (this == SECOND) {
            description += ", 보너스 볼 일치";
        }
        return String.format("%s (%,d원)", description, prize);
    }
}