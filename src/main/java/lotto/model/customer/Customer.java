package lotto.model.customer;

import java.util.List;
import lotto.model.lotto.LottoTicket;

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

    public double calculateProfitRate() {
        return ((double) (calculateTotalProfit()) / paidAmount) * 100;
    }

    private int calculateTotalProfit() {
        int totalProfit = 0;

        for (LottoTicket lottoTicket : lottoTickets) {
            totalProfit += lottoTicket.getProfit();
        }

        return totalProfit;
    }

}
