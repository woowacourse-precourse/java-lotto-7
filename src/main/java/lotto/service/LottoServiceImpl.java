package lotto.service;

import lotto.validation.InputValidator;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(int purchaseAmount) {
        InputValidator.validatePurchaseAmount(purchaseAmount);
        return purchaseAmount / LOTTO_PRICE;
    }
}
