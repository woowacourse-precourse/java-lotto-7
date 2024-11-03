package lotto;

public class LottoCost {

    private final static int LOTTO_COST_MAX = 100000;
    private final static int LOTTO_COST_MIN = 1000;
    public final static int LOTTO_COST_UNIT = 1000;

    private int cost;

    public LottoCost(int cost) {
        validateRange(cost);
        validateUnit(cost);
        this.cost = cost;
    }

    public static LottoCost valueOf(String input) {
        try {
            return new LottoCost(Integer.parseInt(input));
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 양수이어야 합니다.");
        }
    }

    private void validateRange(int cost) {
        if (cost < LOTTO_COST_MIN || cost > LOTTO_COST_MAX) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 이상, 100000 이하만 가능합니다.");
        }
    }

    private void validateUnit(int cost) {
        if (cost % LOTTO_COST_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000의 배수만 가능합니다.");
        }
    }

    public int divideCostByUnit() {
        return cost / LOTTO_COST_UNIT;
    }
}
