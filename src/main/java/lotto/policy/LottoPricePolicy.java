package lotto.policy;

public enum LottoPricePolicy {
    LOTTO_TICKET_PRICE(1_000);

    private final int lottoPrice;

    LottoPricePolicy(int price) {
        this.lottoPrice = price;
    }

    public int price() {
        return lottoPrice;
    }
}
