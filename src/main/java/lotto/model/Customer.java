package lotto.model;

import java.util.ArrayList;
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

    public List<Integer> countMatchingNumbers(WinningLotto winningLotto) {
        List<Integer> matchingNumbers = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            matchingNumbers.add(lottoTicket.countMatchingNumber(winningLotto));
        }
        return matchingNumbers;
    }

}
