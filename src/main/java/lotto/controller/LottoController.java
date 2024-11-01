package lotto.controller;

import lotto.domain.LottoAmount;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public void run(){
        try{
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        int purchasePrice = lottoAmount();
        OutputView.printLottoAmount(purchasePrice);

    }

    public int lottoAmount(){
        String purchasePrice = InputView.inputPurchasePrice();
        LottoAmount lottoAmount = new LottoAmount(purchasePrice);
        return lottoAmount.getAmount();
    }

}
