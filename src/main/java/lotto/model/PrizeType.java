package lotto.model;

public enum PrizeType {
    MATCH_3("3개 일치 (5,000원)", 5000, 3, false),
    MATCH_4("4개 일치 (50,000원)", 50000, 4, false),
    MATCH_5("5개 일치 (1,500,000원)", 1500000, 5, false),
    MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000, 5, true),
    MATCH_6("6개 일치 (2,000,000,000원)", 2000000000, 6, false);


    private final String description;
    private final int reward;
    private final int matchCount;
    private final boolean requiresBonus;


    PrizeType(String description, int reward, int matchCount, boolean requiresBonus) {
        this.description = description;
        this.reward = reward;
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
    }


    public String getDescription() {
        return description;
    }

    public int getReward() {
        return reward;
    }

    public boolean isWinner(int matchCount, boolean hasBonus) {
        if (requiresBonus) {
            return this.matchCount == matchCount && hasBonus;
        }
        return this.matchCount == matchCount;
    }
}
