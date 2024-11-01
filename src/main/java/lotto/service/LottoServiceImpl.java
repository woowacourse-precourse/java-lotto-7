package lotto.service;

import lotto.constants.LottoConstants;
import lotto.validation.PurchaseAmountValidator;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(String purchaseAmountInput) {
        PurchaseAmountValidator.validatePurchaseAmountInput(purchaseAmountInput);

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        PurchaseAmountValidator.validatePurchaseAmount(purchaseAmount);

        return calculateLottoCountFromAmount(purchaseAmount);
    }

    private int calculateLottoCountFromAmount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }
}
