package lotto.service;

import lotto.validator.LottoValidator;

public class LottoService {
    public void createLottoList(int price) {
        LottoValidator.validateLottoPurchaseAmount(price);
    }
}
