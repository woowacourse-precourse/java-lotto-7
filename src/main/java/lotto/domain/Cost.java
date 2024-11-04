package lotto.domain;

public class Cost {

    private static final int LOTTO_PRICE = 1000;
    private final int cost;

    public Cost(int cost) {
        validate(cost);
        this.cost = cost;
    }

    private void validate(int cost) {
        if (cost < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액보다 적은 금액을 입력하실 수 없습니다.");
        }
    }

    public int calculateLottoAmount() {
        return cost / LOTTO_PRICE;
    }

    public int getLottoPurchasePrice() {
        return calculateLottoAmount() * LOTTO_PRICE;
    }

}
