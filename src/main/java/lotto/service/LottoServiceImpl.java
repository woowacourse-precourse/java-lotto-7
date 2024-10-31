package lotto.service;

import lotto.validation.InputValidator;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(String purchaseAmountInput) {
        InputValidator.validatePurchaseAmountInput(purchaseAmountInput);

        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        InputValidator.validatePurchaseAmount(purchaseAmount);

        return calculateLottoCountFromAmount(purchaseAmount);
    }

    private int calculateLottoCountFromAmount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
