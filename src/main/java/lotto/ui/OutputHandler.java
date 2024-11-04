package lotto.ui;

import lotto.domain.LottoTickets;

public class OutputHandler {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());

        lottoTickets.getLottoTickets().forEach(lotto -> {
            System.out.println(lotto.getSortedNumbers());
        });
    }
}
