package lotto.service;

import lotto.domain.LottoTickets;
import lotto.dto.LottoTicketsDto;

public class LottoService {
    private final LottoStore lottoStore;
    private final LottoResults lottoResults;

    public LottoService() {
        this.lottoStore = new LottoStore();
        this.lottoResults = new LottoResults();
    }

    public LottoTicketsDto purchaseLottoTickets(int amount){
        int ticketCount = lottoStore.calculateLottoCount(amount);
        LottoTickets tickets = lottoStore.generateLottoTickets(ticketCount);
        return LottoTicketsDto.from(tickets.getLottoTickets());
    }

    private long calculateTotalEarnings() {
        return lottoResults.calculateTotalEarnings();
    }

}
