package lotto.view;

import lotto.constants.ErrorCode;
import lotto.constants.Value;

public class InputValidator {

    public Long parseMoney(String money) {
        try {
            return Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.MONEY_TYPE_ERROR.getMessage());
        }
    }

    public void validMoney(Long money) {
        if (money < Value.lottoPrice) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_MIN_PRICE_ERROR.getMessage());
        }
        if (money % Value.lottoPrice != 0) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_PRICE_ERROR.getMessage());
        }
    }
}
