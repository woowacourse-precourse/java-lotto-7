package lotto;

import lotto.validators.PurchaseAmountValidator;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String purchaseInput = inputView.getPurchaseAmount();

        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        purchaseAmountValidator.validate(purchaseInput);

        String lottoNumbers = inputView.getLottoNumbers();
    }
}
