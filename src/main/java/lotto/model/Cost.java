package lotto.model;

public class Cost {
    private final int cost;

    private Cost(int cost) {
        validateCost(cost);
        this.cost = cost;
    }

    public static Cost from(int cost){
        return new Cost(cost);
    }

    private void validateCost(int cost){
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.");
        }

        if (cost < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수를 입력할 수 없습니다.");
        }

        if (cost == 0 || String.valueOf(cost).isBlank()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }
    }

    public int getCost() {
        return cost;
    }
}
