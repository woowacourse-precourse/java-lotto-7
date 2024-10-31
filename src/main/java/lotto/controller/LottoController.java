package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    Integer buyAmount;
    String winNumbers;
    Integer bonusNumber;

    public static void run(){
        InputView.inputBuyAmount();
    }

}
