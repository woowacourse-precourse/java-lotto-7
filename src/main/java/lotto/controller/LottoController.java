package lotto.controller;

import lotto.model.Cash;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoInputView lottoInputView = new LottoInputView();
    public void start(){
        lottoOutputView.printLottoAmountNotification();
        String cashAmount = lottoInputView.getUserInput();
        Cash cash = new Cash(cashAmount);
    }
}
