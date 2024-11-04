package lotto.view;

public enum Winnings {
    THREE_MATCH(3, "3개 일치 (5,000원)", 5000),
    FOUR_MATCH(4, "4개 일치 (50,000원)", 50000),
    FIVE_MATCH(5, "5개 일치 (1,500,000원)", 1500000),
    FIVE_MATCH_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX_MATCH(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int matchCount;
    private final String description;
    private final int prize;

    Winnings(int matchCount, String description, int prize) {
        this.matchCount = matchCount;
        this.description = description;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }

    public static Winnings getByMatchCount(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) {
            return SIX_MATCH;
        }
        if (matchCount == 5 && bonusMatch) {
            return FIVE_MATCH_BONUS;
        }

        if(matchCount == 5){
            return FIVE_MATCH;
        }
        if (matchCount == 4) {
            return FOUR_MATCH;
        }
        if (matchCount == 3) {
            return THREE_MATCH;
        }
        return null;
    }
}
