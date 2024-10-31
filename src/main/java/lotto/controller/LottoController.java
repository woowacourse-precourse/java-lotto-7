package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    private String winNumbersStr;

    private Integer buyAmount;
    private String winNumbers;
    private Integer bonusNumber;

    public void run(){
        buyAmount = InputView.inputBuyAmount();
        winNumbersStr = InputView.inputWinNumbers();
    }

}
