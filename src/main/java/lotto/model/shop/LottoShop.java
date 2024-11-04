package lotto.model.shop;

import lotto.model.Lottos;
import lotto.model.exception.PurchaseMoneyInvalidException;
import lotto.model.number_generator.RandomNumberGenerator;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    public Lottos purchaseRandomLottos(int purchaseMoney, RandomNumberGenerator randomNumberGenerator) {

        validatePurchaseMoney(purchaseMoney);
        int lottoCount = purchaseMoney / LOTTO_PRICE;

        return Lottos.generate(lottoCount, randomNumberGenerator);
    }

    private void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney < LOTTO_PRICE) {
            String detail = String.format("로또 구매 금액은 %d원 이상이어야 합니다.", LOTTO_PRICE);
            throw PurchaseMoneyInvalidException.lottoMoneyTooSmall(detail);
        }

        if (purchaseMoney % LOTTO_PRICE != 0) {
            String detail = String.format("로또 구매는 %d원 단위로만 가능합니다.", LOTTO_PRICE);
            throw PurchaseMoneyInvalidException.lottoMoneyNotDivisible(detail);
        }
    }
}
