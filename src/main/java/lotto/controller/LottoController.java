package lotto.controller;

import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView){
        this.lottoView = lottoView;
    }

    public void run(){
        int lottoPurchasePrice = requestLottoPurchasePrice();

    }


    private int requestLottoPurchasePrice(){
        String lottoPurchasePrice = lottoView.requestLottoPurchasePrice();

        return 0;
    }
}
