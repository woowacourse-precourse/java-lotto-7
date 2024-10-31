package lotto.service;

import lotto.constants.LottoConstants;
import lotto.validation.InputValidator;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(String purchaseAmountInput) {
        InputValidator.validatePurchaseAmountInput(purchaseAmountInput);

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        InputValidator.validatePurchaseAmount(purchaseAmount);

        return calculateLottoCountFromAmount(purchaseAmount);
    }

    private int calculateLottoCountFromAmount(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }
}
