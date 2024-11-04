package lotto;

import lotto.exception.InvalidCostException;

import static lotto.exception.ErrorMessage.*;

public class LottoCost {

    private final static int LOTTO_COST_MAX = 10000000;
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
            throw new InvalidCostException(INVALID_COST_FORMAT.getMessage());
        }
    }

    private void validateRange(int cost) {
        if (cost < LOTTO_COST_MIN || cost > LOTTO_COST_MAX) {
            throw new InvalidCostException(INVALID_COST_RANGE.getMessage());
        }
    }

    private void validateUnit(int cost) {
        if (cost % LOTTO_COST_UNIT != 0) {
            throw new InvalidCostException(INVALID_COST_UNIT.getMessage());
        }
    }

    public int divideCostByUnit() {
        return cost / LOTTO_COST_UNIT;
    }
}
