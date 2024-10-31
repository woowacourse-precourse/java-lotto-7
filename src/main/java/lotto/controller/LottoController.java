package lotto.controller;

import lotto.model.User;
import lotto.view.InputView;

public class LottoController {

    private User user;

    public void run(){
        beforeLotto();
        //startLotto();
        //afterLotto();
    }

    public void beforeLotto(){
        int buyAmount = InputView.inputBuyAmount();
        user = new User(buyAmount);
    }
}
