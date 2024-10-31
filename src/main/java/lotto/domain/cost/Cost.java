package lotto.domain.cost;

public record Cost(int value) {

    public static Cost of(int cost) {
        return new Cost(cost);
    }

    public int getPurchaseCount() {
        return 0;
    }
}
