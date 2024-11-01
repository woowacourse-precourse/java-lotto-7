package lotto.model;

import java.util.List;
import java.util.Map;

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

    public double calculateProfitRate() {
        return ((double) (getTotalProfit()) / paidAmount) * 100;
    }

    private int getTotalProfit() {
        int totalProfit = 0;

        for (LottoTicket lottoTicket : lottoTickets) {
            totalProfit += lottoTicket.getProfit();
        }

        return totalProfit;
    }

    public Map<Rank, Integer> countRank(Map<Rank, Integer> rankCounts) {
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoTicket.countRank(rankCounts);
        }

        return rankCounts;
    }
}
