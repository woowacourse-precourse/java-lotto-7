package lotto.util;

import lotto.constants.LottoConstants;

public class LottoConverter {

    public int convertPriceToLotto(int price) {
        Validator.validatePrice(price);
        return price / LottoConstants.BASE_PRICE;
    }
}
