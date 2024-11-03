package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.dto.LottoTicketsDto;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "\n당첨 통계\n---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %s입니다.";
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public static void printLottoTickets(List<LottoTicketsDto> lottoTickets) {
        System.out.println(lottoTickets.size() + PURCHASE_MESSAGE);
        lottoTickets.forEach(tickets -> System.out.println(tickets.getNumbers()));
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }
}