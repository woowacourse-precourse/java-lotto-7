package lotto.model;

import lotto.constant.LottoConfiguration;

public class PurchasePrice {

    public static final String NOT_POSITIVE_PRICE_EXCEPTION_MESSAGE = "0이하의 금액은 허용하지 않습니다.";
    public static final String EXIST_CHANGE_EXCEPTION_MESSAGE =
            String.format("거스름돈이 남는 금액은 허용하지 않습니다. (로또 금액 : %d)", LottoConfiguration.LOTTO_PRICE);
    private final int price;

    public PurchasePrice(int price) {
        validatePositivePrice(price);
        validateNoChange(price);
        this.price = price;
    }

    private void validatePositivePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_PRICE_EXCEPTION_MESSAGE);
        }
    }

    private void validateNoChange(int price) {
        if (price % LottoConfiguration.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(EXIST_CHANGE_EXCEPTION_MESSAGE);
        }
    }

    public int getPrice() {
        return price;
    }
}
