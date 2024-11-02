package lotto.service;

import lotto.model.LottoTickets;
import lotto.model.PurchaseAmount;

public class LottoService {

    public LottoTickets purchaseLotto(int amount){
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        return new LottoTickets(purchaseAmount);
    }

}
