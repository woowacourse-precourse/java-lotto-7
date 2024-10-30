package lotto;

public class Controller {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String purchaseAmount = inputView.readPurchaseAmount();
        Validator validator = new Validator();
        validator.validatePurchaseAmount(purchaseAmount);
    }
}
