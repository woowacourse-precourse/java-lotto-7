package lotto;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    NONE(0, 0, "미당첨");

    private final int matchCount;
    private final int prize;
    private final String description;

    Rank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return NONE;
        }

        if (matchCount == 6) {
            return FIRST;
        }

        if (matchCount == 5) {
            if (matchBonus) {
                return SECOND;
            }

            if (!matchBonus) {
                return THIRD;
            }
        }

        if (matchCount == 4) {
            return FOURTH;
        }

        return FIFTH;
    }

    public boolean isWinning() {
        return this != NONE;
    }

    public long calculatePrize(int count) {
        return (long) prize * count;
    }

    public String getWinningResult(int count) {
        return String.format("%s (%,d원) - %d개", description, prize, count);
    }

}
