package lotto.service;

import lotto.model.LottoTickets;
import lotto.model.PurchaseAmount;
import lotto.validator.PurchaseAmountValidator;

public class LottoPurchaseService {

    public LottoTickets purchaseLotto(int amount) {
        PurchaseAmountValidator.validateAmount(amount);
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        return new LottoTickets(purchaseAmount);
    }

}
