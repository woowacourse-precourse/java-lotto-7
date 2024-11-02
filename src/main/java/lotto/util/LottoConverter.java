package lotto.util;

import lotto.constants.LottoConstants;

public class LottoConverter {

    private static final String UNDER_PRICE_ERROR = "[ERROR] 최소 구입 금액은 " + LottoConstants.BASE_PRICE + "원 이상이어야 합니다.";
    private static final String UNIT_ERROR = "[ERROR] 금액은 " + LottoConstants.BASE_PRICE + "원 단위여야 합니다.";

    public int convertPriceToLotto(int price) {
        validatePrice(price);
        return price / LottoConstants.BASE_PRICE;
    }

    private void validatePrice(int price) {
        if (price < LottoConstants.BASE_PRICE) {
            throw new IllegalArgumentException(UNDER_PRICE_ERROR);
        }
        if (price % LottoConstants.BASE_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR);
        }
    }
}
