package lotto.view;

import lotto.model.LottoTickets;

public class LottoGameOutputView {

    private LottoGameOutputView() {
    }

    public static void printTicketCount(LottoTickets lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.getTicketCount() + "개를 구매했습니다.");
    }
}
