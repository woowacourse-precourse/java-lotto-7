package lotto.presentation.view;

import lotto.application.dto.LottoTicketsDTO;
import lotto.domain.model.Lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASED_TICKETS_MESSAGE = "\n%d개를 구매했습니다.";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printLottoTickets(LottoTicketsDTO lottoTicketsDTO) {
        List<List<Integer>> tickets = lottoTicketsDTO.getTickets();
        System.out.println(String.format(PURCHASED_TICKETS_MESSAGE, tickets.size()));
        for (List<Integer> ticket : tickets) {
            System.out.println(ticket);
        }
    }
}
