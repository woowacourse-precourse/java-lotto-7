package lotto.model.shop;

import lotto.model.Lottos;
import lotto.model.exception.PurchaseMoneyInvalidException;
import lotto.model.number_generator.RandomNumberGenerator;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;

    public Lottos purchaseRandomLottos(int money, RandomNumberGenerator randomNumberGenerator) {

        validateMoney(money);
        int lottoCount = money / LOTTO_PRICE;

        return Lottos.generateBy(randomNumberGenerator, lottoCount);
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw PurchaseMoneyInvalidException.lottoMoneyTooSmall();
        }

        if (money % LOTTO_PRICE != 0) {
            throw PurchaseMoneyInvalidException.lottoMoneyNotDivisible();
        }
    }
}
