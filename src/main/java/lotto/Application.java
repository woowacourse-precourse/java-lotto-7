package lotto;

import lotto.controller.PurchaseAmountController;
import lotto.injection.ObjectFactory;

public class Application {
    public static void main(String[] args) {
        ObjectFactory objectFactory = new ObjectFactory();

        PurchaseAmountController purchaseAmountController = objectFactory.purchaseAmountController();
        purchaseAmountController.run();
    }
}
