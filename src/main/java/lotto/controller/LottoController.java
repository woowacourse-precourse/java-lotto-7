package lotto.controller;

import lotto.model.Cash;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoInputView lottoInputView = new LottoInputView();
    public void start(){
        lottoOutputView.printCashNotification();
        Cash cash = initializeCash();
    }

    private Cash initializeCash(){
        while (true) {
            try {
                String cashAmount = lottoInputView.getUserInput();
                return new Cash(cashAmount);
            } catch (IllegalArgumentException e) {
                lottoOutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
