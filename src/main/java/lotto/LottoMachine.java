package lotto;

import lotto.enums.ErrorCode;
import lotto.enums.Value;

public class LottoMachine {

    public void buyLotto(Long money) {
        validMoney(money);
        Long lottoCount = money / Value.lottoPrice;

    }

    private void validMoney(Long money) {
        if (money < Value.lottoPrice) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_MIN_PRICE_ERROR.getMessage());
        }
        if (money % Value.lottoPrice != 0) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_PRICE_ERROR.getMessage());
        }
    }
}
