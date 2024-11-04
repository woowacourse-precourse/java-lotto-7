package lotto.model;

public enum Rank {
    FIRST(2000000000, 6, false, "", "2,000,000,000"),
    SECOND(30000000, 5, true, "보너스 볼 일치", "30,000,000"),
    THIRD(1500000, 5, false, "", "15,000,000"),
    FOURTH(50000, 4, false, "", "50,000"),
    FIFTH(5000, 3, false, "", "5,000");

    private final int prize;
    private final int requiredCount;
    private final boolean matchBonus;
    private final String bonusMessage;
    private final String prizeMessage;

    Rank(int prize, int requiredCount, boolean matchBonus, String bonusMessage, String prizeMessage) {
        this.prize = prize;
        this.requiredCount = requiredCount;
        this.matchBonus = matchBonus;
        this.bonusMessage = bonusMessage;
        this.prizeMessage = prizeMessage;
    }

    public static Rank getRank(int requiredCount, boolean matchBonus) {
        if (requiredCount == FIRST.requiredCount) {
            return FIRST;
        }
        if (requiredCount == SECOND.requiredCount && matchBonus == SECOND.matchBonus) {
            return SECOND;
        }
        if (requiredCount == THIRD.requiredCount && matchBonus == THIRD.matchBonus) {
            return THIRD;
        }
        if (requiredCount == FOURTH.requiredCount) {
            return FOURTH;
        }
        if (requiredCount == FIFTH.requiredCount) {
            return FIFTH;
        }
        return null;
    }

    public static int getPrize(Rank rank) {
        if (rank != null) {
            return rank.prize;
        }
        return 0;
    }
}