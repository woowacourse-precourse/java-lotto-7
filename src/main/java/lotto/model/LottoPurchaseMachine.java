package lotto.model;

import lotto.Lotto;

public class LottoPurchaseMachine {

    private final int purchaseAmount;

    public LottoPurchaseMachine(int purchaseAmount) {

        this.purchaseAmount = purchaseAmount;
    }

    private int calculateLottoAmount() {
        return purchaseAmount / Lotto.PRICE_PER_TICKET;
    }


}
