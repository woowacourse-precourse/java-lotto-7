package lotto.domain;

import java.util.List;

public class LottoGame {
    private final LottoTicketBundle lottoTicketBundle;
    private final WinningTicket winningTicket;
    private final ProfitCalculator profitCalculator;

    public LottoGame(ProfitCalculator profitCalculator, LottoGenerateStrategy strategy, WinningTicket winningTicket) {
        this.profitCalculator = profitCalculator;
        this.lottoTicketBundle = LottoTicketBundle.from(strategy, profitCalculator.getTicketCount());
        this.winningTicket = winningTicket;
    }

    public List<Prize> getPrizes() {
        return lottoTicketBundle.getPrizes(winningTicket);
    }

    public float calculateEarningRate() {
        int totalReward = lottoTicketBundle.getTotalReward(winningTicket);
        return profitCalculator.calculateEarningRate(totalReward);
    }

    public String getPurchasedTickets() {
        return lottoTicketBundle.toString();
    }

    public int getPurchasedTicketsCount() {
        return profitCalculator.getTicketCount();
    }
}
