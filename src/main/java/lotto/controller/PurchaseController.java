package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;

public class PurchaseController {
    private static final int LOTTO_PRICE = 1000;
    private static final String AMOUNT_MUST_BE_GREATER_THAN_ZERO = "금액은 0보다 커야합니다.";
    private static final String AMOUNT_MUST_ME_MULTIPLE_OF_THOUSAND = "천원단위의 금액만 투입 가능합니다.";
    private final LottoFactory lottoFactory;

    public PurchaseController(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public Lottos purchaseLotto(Integer amount) {
        validateAmount(amount);
        int count = getLottoCount(amount);
        return lottoFactory.getLottosCountOf(count);
    }

    private void validateAmount(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(AMOUNT_MUST_BE_GREATER_THAN_ZERO);
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_MUST_ME_MULTIPLE_OF_THOUSAND);
        }
    }

    private int getLottoCount(Integer amount) {
        return amount / LOTTO_PRICE;
    }
}
