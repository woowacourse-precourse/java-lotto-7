package lotto.view.output;

import static lotto.handler.OutputHandler.OUTPUT_LOTTO_TICKETS_COUNT;

import lotto.domain.LottoTickets;

public class OutputLottoTicketsView {
    public void showLottoTickets(int lottoTicketsCount, LottoTickets lottoTickets) {
        System.out.printf((OUTPUT_LOTTO_TICKETS_COUNT) + "%n", lottoTicketsCount);
        lottoTickets.getLottoTickets().forEach(System.out::println);
        System.out.println();
    }
}
