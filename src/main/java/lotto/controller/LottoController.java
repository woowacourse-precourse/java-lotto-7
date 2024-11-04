package lotto.controller;

import lotto.dto.request.MoneyRequest;
import lotto.dto.response.TicketResponse;
import lotto.service.LottoTickets;

public class LottoController {
    private final LottoTickets lottoTickets;

    public LottoController(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public TicketResponse buyTicket(MoneyRequest money) {
        return lottoTickets.buyTicket(money.money());
    }
}
