package lotto.controller;

import lotto.Application;
import lotto.view.ViewInput;

public class ApplicationController {
    private final ViewInput viewInput;

    public ApplicationController(ViewInput viewInput) {
        this.viewInput = viewInput;
    }


    public void run(){
        int purchaseAmount = viewInput.receivePurchaseAmount();







    }
}
