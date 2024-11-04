package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public class LottoService {
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoService(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public List<Lotto> generateLottoTickets(int lottoTicketCount) {
        return lottoTicketGenerator.generateMultipleLottoTickets(lottoTicketCount);
    }
}
