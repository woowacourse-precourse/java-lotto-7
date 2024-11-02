package lotto.model.service;

import lotto.model.ErrorMessage;
import lotto.model.RandomNumberGenerator;

public class LottoSellingMachine {

    public Lottos sell(Long money) {
        validateMoney(money);
        Long lottoCount = calculateLottoCount(money);
        return Lottos.from(lottoCount, new RandomNumberGenerator());
    }

    private void validateMoney(Long money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_PURCHASE_AMOUNT.getMessage());
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    private Long calculateLottoCount(Long money) {
        return money / 1000;
    }
}
