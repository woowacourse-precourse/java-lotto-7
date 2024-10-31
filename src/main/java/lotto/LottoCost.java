package lotto;

public class LottoCost {

    private final int LOTTO_COST_MAX = 100000;
    private final int LOTTO_COST_MIN = 1000;

    private int cost;

    public LottoCost(int cost) {
        this.cost = cost;
    }

    private void validateCost(int cost) {
        if(cost < LOTTO_COST_MIN || cost > LOTTO_COST_MAX) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상, 100000 이하만 가능합니다.");
        }
    }
}
