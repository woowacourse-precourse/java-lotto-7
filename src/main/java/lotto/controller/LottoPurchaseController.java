package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicketPurchase;
import lotto.view.LottoTicketPurchaseView;

import java.util.List;

public class LottoPurchaseController {
    private final LottoTicketPurchase lottoTicketPurchase;
    private final LottoTicketPurchaseView lottoTicketPurchaseView = new LottoTicketPurchaseView();

    public LottoPurchaseController(Integer buyCount) {
        this.lottoTicketPurchase = new LottoTicketPurchase(buyCount);
        lottoTicketPurchaseView.printPurchaseCount(buyCount);
    }

    public void printPurchaseLotto() {
        lottoTicketPurchaseView.printLottoPurchase(lottoTicketPurchase.getLottoTickets());
    }

    public List<Lotto> getBuyLottoInfoList() {
        return this.lottoTicketPurchase.getLottoTickets();
    }
}
