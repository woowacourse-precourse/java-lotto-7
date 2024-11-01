package lotto.model.customer;

import java.util.List;
import java.util.Map;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.Rank;
import lotto.model.lotto.WinningLotto;

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

    public void determineRanksOfLottoTickets(WinningLotto winningLotto) {
        this.lottoTickets.forEach(lottoTicket -> lottoTicket.determineRank(winningLotto));
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

    public Map<Rank, Integer> countRank(Map<Rank, Integer> rankCounts) {
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoTicket.countRank(rankCounts);
        }

        return rankCounts;
    }
}
