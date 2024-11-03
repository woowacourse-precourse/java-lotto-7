package lotto.model;

public enum LottoReward {
    PRICE_PER_TICKET(1000),
    MATCH_3_REWARD(5000),
    MATCH_4_REWARD(50000),
    MATCH_5_REWARD(1500000),
    MATCH_5_BONUS_REWARD(30000000),
    MATCH_6_REWARD(2000000000);

    private final int reward;

    LottoReward(int reward) {
        this.reward = reward;
    }

    public String getReward() {
        return String.format("%,d", this.reward);
    }
}
