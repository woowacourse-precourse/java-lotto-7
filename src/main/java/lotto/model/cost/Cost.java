package lotto.model.cost;

public class Cost {
    private final int cost;

    private Cost(int cost) {
        validateCost(cost);
        this.cost = cost;
    }

    public static Cost from(int cost) {
        return new Cost(cost);
    }

    private void validateCost(int cost) {
        isValidUnitCost(cost);

        isCostNegative(cost);

        isCostBlank(cost);
    }

    private void isValidUnitCost(int cost) {
        if (cost % CostUnit.COST_UNIT.getUnit() != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.");
        }
    }

    private void isCostNegative(int cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수를 입력할 수 없습니다.");
        }
    }

    private void isCostBlank(int cost) {
        if (cost == 0 || String.valueOf(cost).isBlank()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }
    }

    public int getCost() {
        return cost;
    }
}
