package lotto.domain;

import lotto.common.validator.CostValidator;

public class Cost {
    private final int cost;

    public Cost(String cost) {
        CostValidator.validate(cost);
        this.cost = Integer.parseInt(cost);
    }

    public int getCost() {
        return cost;
    }
}
