package lotto.service;

import lotto.constants.OutputViewConstants;

public class OutputService {
    public void showPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + OutputViewConstants.PURCHASE_AMOUNT_DESCRIPTION);
    }
}
