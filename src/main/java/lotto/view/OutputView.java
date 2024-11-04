package lotto.view;

import lotto.domain.LottoTickets;

public class OutputView {
    private static final String purchaseMessage = "개를 구매했습니다.";

    private final LottoTickets lottoTickets;

    public OutputView(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void showLottoTickets(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + purchaseMessage);
        System.out.println(lottoTickets.getLottoTicket());
    }
}
