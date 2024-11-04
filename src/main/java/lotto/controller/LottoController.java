package lotto.controller;

import lotto.view.InputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public void start(){
        int purchaseAmount = InputView.getPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        System.out.println(lottoCount + "개를 구매했습니다.");;
    }
}
