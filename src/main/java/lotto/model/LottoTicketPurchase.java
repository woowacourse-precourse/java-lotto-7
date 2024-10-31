package lotto.model;

import java.util.List;

public class LottoTicketPurchase {
    List<Lotto> lottoTickets;

    public LottoTicketPurchase(List<Lotto> lottoTickets) {
        validationTicketNullCheck(lottoTickets);
        this.lottoTickets = lottoTickets;
    }

    private void validationTicketNullCheck(List<Lotto> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
           throw new IllegalArgumentException("[ERROR] 로또 티켓이 발급되지 않았습니다!");
        }
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
