package lotto.controller;

import lotto.model.Cash;
import lotto.model.Lotto;
import lotto.service.LottoProvider;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    private final LottoOutputView lottoOutputView = new LottoOutputView();
    private final LottoInputView lottoInputView = new LottoInputView();
    private final LottoProvider lottoProvider = new LottoProvider();
    public void start(){
        lottoOutputView.printCashNotification();
        Cash cash = requestCashInput();

        List<Lotto> lottoBundle = buyLottoBundle(cash);
        lottoOutputView.printLottoBundleAmount(lottoBundle.size());
        lottoOutputView.printLottoInBundle(lottoBundle);
    }

    private Cash requestCashInput(){
        while (true) {
            try {
                String cashAmount = lottoInputView.getUserInput();
                return new Cash(cashAmount);
            } catch (IllegalArgumentException e) {
                lottoOutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Lotto> buyLottoBundle(Cash cash){
        return lottoProvider.buyLottoBundle(cash);
    }
}
