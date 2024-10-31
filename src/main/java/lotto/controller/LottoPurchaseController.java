package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoTicketPurchase;

import java.util.List;

public class LottoPurchaseController {
    private final LottoTicketPurchase lottoTicketPurchase;

    public LottoPurchaseController(Integer buyCount) {
        this.lottoTicketPurchase = new LottoTicketPurchase(buyCount);
    }




    public List<Lotto> getBuyLottoInfoList() {
        return this.lottoTicketPurchase.getLottoTickets();
    }

}
