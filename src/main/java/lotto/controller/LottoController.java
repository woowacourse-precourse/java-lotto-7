package lotto.controller;

import lotto.view.LottoView;

public class LottoController {
    private LottoView lottoView;
    public LottoController(LottoView lottoView){
        this.lottoView = lottoView;
    }
    public void run(){
        int lottoAmount = lottoView.inputPurchaseAmount();
        System.out.println(lottoAmount);
    }
}
