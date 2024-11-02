package lotto.controller;

import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    public void start(){
        lottoOutputView.printLottoAmountNotification();
    }
}
