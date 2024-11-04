package lotto.domain;

public class LottoPrice {
    private static final int LOTTO_PRICE_AMOUNT = 1000;

    private final int price;

    public LottoPrice(int price) {
        amountValidate(price);
        this.price = price;
    }

    private void amountValidate(int price) {
        if (!(price % LOTTO_PRICE_AMOUNT == 0)) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_PRICE_AMOUNT + "원 단위여야 합니다.");
        }
    }

    public int getTicketQuantity() {
        return price / LOTTO_PRICE_AMOUNT;
    }
}
