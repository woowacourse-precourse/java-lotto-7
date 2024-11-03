package lotto.domain.money;

import lotto.common.exception.InvalidLottoMoneyException;

public class LottoMoney {

    private static final int LOTTO_UNIT_PRICE = 1000;

    private final int purchasedAmount;
    private final int lottoCount;

    public LottoMoney(int purchasedAmount) {
        validateLottoMoney(purchasedAmount);
        this.purchasedAmount = purchasedAmount;
        this.lottoCount = purchasedAmount / LOTTO_UNIT_PRICE;
    }

    public int getPurchasedAmount() {
        return this.purchasedAmount;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    private void validateLottoMoney(int money) {
        if(money < LOTTO_UNIT_PRICE || money % LOTTO_UNIT_PRICE != 0) {
            throw new InvalidLottoMoneyException(money);
        }
    }
}
