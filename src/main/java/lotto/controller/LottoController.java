package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    public void crateLottoTicket() {
        LottoService lottoService = new LottoService();
        int ticketQuantity = lottoService.purchaseTicket();
    }
}
