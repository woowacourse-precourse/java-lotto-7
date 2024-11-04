package lotto.model;

import static lotto.utils.Constants.LOTTO_PRICE;

public class Cashier {
    public Cashier() {

    }

    public int getLottoCount(int price) {
        validatePriceAmount(price);
        return (price / LOTTO_PRICE);
    }

    private void validatePriceAmount(int price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해야 합니다.");
        }
    }
}
