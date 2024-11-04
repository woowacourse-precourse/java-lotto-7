package lotto.service.constant;

public enum Cost {

    ONE_LOTTO_GAME(1000L),
    BASIC_PRIZE_MONEY(0L);

    private final Long cost;

    Cost(Long cost) {
        this.cost = cost;
    }

    public Long getCost() {
        return cost;
    }
}
