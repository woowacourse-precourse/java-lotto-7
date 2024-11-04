package lotto.domain;

import java.util.List;

public class LottoGame {
    private final LottoTicketBundle lottoTicketBundle;
    private final WinningTicket winningTicket;
    private final UserAccount userAccount;

    public LottoGame(UserAccount userAccount, LottoTicketBundle lottoTicketBundle, WinningTicket winningTicket) {
        this.userAccount = userAccount;
        this.lottoTicketBundle = lottoTicketBundle;
        this.winningTicket = winningTicket;
    }

    public List<Prize> getPrizes() {
        return lottoTicketBundle.getPrizes(winningTicket);
    }

    public float calculateEarningRate() {
        int totalReward = lottoTicketBundle.getTotalReward(winningTicket);
        return userAccount.calculateEarningRate(totalReward);
    }

    public String getPurchasedTickets() {
        return lottoTicketBundle.toString();
    }

    public int getPurchasedTicketsCount() {
        return userAccount.getTicketCount();
    }
}
