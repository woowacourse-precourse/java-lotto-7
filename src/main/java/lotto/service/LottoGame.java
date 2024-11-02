package lotto.service;

import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputReader;

public class LottoGame {

    private final InputReader inputReader;

    public LottoGame(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public void issueLottoNumbers() {
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        String purchaseAmount = inputReader.inputPurchaseAmount();

        purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);


    }
}
