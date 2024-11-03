package lotto.custom.service;

import lotto.custom.model.LottoMaker;
import lotto.custom.model.Lottos;
import lotto.custom.validator.InputValidator;

public class LottoPurchaseService {
    private final InputValidator inputValidator;
    private final LottoMaker lottoMaker;

    public LottoPurchaseService() {
        this.inputValidator = new InputValidator();
        this.lottoMaker = new LottoMaker();
    }

    public Lottos run(String purchaseAmountInput) {
        inputValidator.validatePurchaseAmountInput(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput.trim());
        return lottoMaker.run(purchaseAmount);
    }
}