package lotto.controller;

import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.util.Validator;
import lotto.view.LottoInputView;

public class LottoController {

    private final LottoInputView lottoInputView;

    public LottoController(LottoInputView lottoInputView) {
        this.lottoInputView = lottoInputView;
    }

    public void run() {
        buyLottoTicket();
    }

    private LottoTicket buyLottoTicket() {
        while (true) {
            try {
                return createLottoTicket();
            } catch (IllegalArgumentException exception) {
            }
        }
    }

    private LottoTicket createLottoTicket() {
        String purchaseMoney = lottoInputView.getLottoPurchaseMoney();
        return LottoStore.makeLottoTicket(purchaseMoney);
    }
}
