package lotto;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchedCount;
    private final boolean hasBonus;
    private final long prize;

    Rank(int matchedCount, boolean hasBonus, long prize) {
        this.matchedCount = matchedCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank of(int count, boolean bonus) {
        if (count == 6) {
            return FIRST;
        }
        if (count == 5 && bonus) {
            return SECOND;
        }
        if (count == 5) {
            return THIRD;
        }
        if (count == 4) {
            return FOURTH;
        }
        if (count == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public long getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        switch (this) {
            case FIRST:
                return "6개 일치 (2,000,000,000원)";
            case SECOND:
                return "5개 일치, 보너스 볼 일치 (30,000,000원)";
            case THIRD:
                return "5개 일치 (1,500,000원)";
            case FOURTH:
                return "4개 일치 (50,000원)";
            case FIFTH:
                return "3개 일치 (5,000원)";
            default:
                return "";
        }
    }
}