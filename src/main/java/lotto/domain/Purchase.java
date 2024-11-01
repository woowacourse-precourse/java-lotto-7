package lotto.domain;

public class Purchase {
    private final int price;

    public Purchase(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매는 1천원 단위로 가능합니다.");
        }
    }

    public int calculatePurchasableLotto() {
        return price / 1000;
    }
}
