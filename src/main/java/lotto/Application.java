package lotto;

import lotto.service.Purchase;
import lotto.view.input.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = new Input();
        Purchase purchase = new Purchase(input.purchaseAmount());
        System.out.println(purchase.getPurchaseAccount());

    }
}
