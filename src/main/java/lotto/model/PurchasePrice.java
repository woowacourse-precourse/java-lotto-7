package lotto.model;

import static lotto.model.constant.Lotto.PRICE_PER_LOTTO;

import lotto.util.ExceptionHelper;

public class PurchasePrice {
    private static final String INVALID_PRICE_ERROR_MESSAGE = "구입 금액은 1,000원 단위로 입력해주세요.";

    private final int price;

    public PurchasePrice(final int price) {
        validatePurchasePrice(price);
        this.price = price;
    }

    private static void validatePurchasePrice(final int price) {
        if (price % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(ExceptionHelper.errorMessage(INVALID_PRICE_ERROR_MESSAGE));
        }
    }

    public int get() {
        return price;
    }
}