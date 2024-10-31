package lotto.controller;

import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
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
        LottoTicket lottoTicket = LottoStore.makeLottoTicket(purchaseMoney);
        lottoOutputView.printLottoCount(lottoTicket.getLottosCount());

        return lottoTicket;
    }
}
