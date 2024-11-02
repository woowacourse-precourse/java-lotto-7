package lotto.committee;

public enum PrizeMoney {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000);

    private final Integer won;

    private PrizeMoney(Integer won) {
        this.won = won;
    }

    public Integer getWon() {
        return this.won;
    }
}
