package lotto.model;

public enum Rule {
    FIFTH(5_000, "3개 일치"),
    FOURTH(50_000, "4개 일치"),
    THIRD(1_500_000, "5개 일치"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000, "6개 일치");

    private final int prize;
    private final String description;

    Rule(int prize, String description) {
        this.prize = prize;
        this.description = description;
    }

    public static Rule valueOf(int matchCount, boolean hasBonusMatch) {
        if (matchCount == 3) {
            return FIFTH;
        }
        else if (matchCount == 4) {
            return FOURTH;
        }
        else if (matchCount == 5 && !hasBonusMatch) {
            return THIRD;
        }
        else if (matchCount == 5) {
            return SECOND;
        }
        else if (matchCount == 6) {
            return FIRST;
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
