package lotto.model;

import java.util.List;

public class Customer {
    private final int paidAmount;
    private final List<LottoTicket> lottoTickets;

    public Customer(int paidAmount, List<LottoTicket> lottoTickets) {
        this.paidAmount = paidAmount;
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public void determineRanks(WinningLotto winningLotto) {
        this.lottoTickets.forEach(lottoTicket -> lottoTicket.determineRank(winningLotto));
    }

}
