package lotto.service;

import lotto.utils.PurchaseAmount;

public class LottoService {

    public int makeLotteryTickets(String purchaseAmountInput) {
        PurchaseAmount.validateInput(purchaseAmountInput);
        int castedPurchaseAmount = PurchaseAmount.validatePurchaseAmount(purchaseAmountInput);
        int numberOfTickets = PurchaseAmount.calculateNumberOfLotteryTickets(castedPurchaseAmount);

        return numberOfTickets;
    }
    
}
