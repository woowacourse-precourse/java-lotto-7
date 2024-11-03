package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.service.TicketService;

import java.util.List;

public class LottoController {
    private final TicketService ticketService;
    private final LottoGenerator lottoGenerator;

    public LottoController(TicketService ticketService) {
        this.ticketService = ticketService;
        this.lottoGenerator = new LottoGenerator();
    }

    public List<Lotto> excuteLottos() {
        int ticketCount = ticketService.getTicketCount();
        return lottoGenerator.createMultipleLottos(ticketCount);
    }
}
