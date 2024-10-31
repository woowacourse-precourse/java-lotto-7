package lotto.controller;

import lotto.model.LottoStore;
import lotto.model.LottoTicket;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    private final LottoService lottoService;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView, LottoService lottoService) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoTicket lottoTicket = buyLottoTicket();
        lottoOutputView.printLottoCount(lottoTicket.getLottosCount());
        lottoOutputView.printLottoTicket(lottoTicket.getLottoTicketNumbers());
    }

    private LottoTicket buyLottoTicket() {
        while (true) {
            try {
                String purchaseMoney = lottoInputView.getLottoPurchaseMoney();
                return lottoService.createLottoTicket(purchaseMoney);
            } catch (IllegalArgumentException exception) {
            }
        }
    }

}
