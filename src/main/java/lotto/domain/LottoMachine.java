package lotto.domain;

import static lotto.validator.LottoAmountValidator.*;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(int purchaseAmount, LottoNumberGenerator lottoNumberGenerator) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    private int calculateLottoAmount() {
        validate(purchaseAmount, LOTTO_PRICE);
        return purchaseAmount / LOTTO_PRICE;
    }
}
