package lotto.controller;

import lotto.validation.Validation;
import lotto.view.Input;

public class LottoPurchase {
    Input input = new Input();
    Validation validation = new Validation();

    protected int purchaseAmount() {
        int amount = input.price();
        validation.purchase(amount);

        return amount/1000;
    }


}



