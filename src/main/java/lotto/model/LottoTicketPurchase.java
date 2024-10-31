package lotto.model;

import java.util.List;

public class LottoTicketPurchase {
    List<Lotto> lottoTickets;
    Integer ticketCount;

    public LottoTicketPurchase(List<Lotto> lottoTickets, Integer ticketCount) {
        validationTicketNullCheck(lottoTickets);
        this.lottoTickets = lottoTickets;
        this.ticketCount = ticketCount;
    }

    private void validationTicketNullCheck(List<Lotto> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
           throw new IllegalArgumentException("[ERROR] 로또 티켓이 발급되지 않았습니다!");
        }
    }
}
