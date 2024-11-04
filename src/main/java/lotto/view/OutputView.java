package lotto.view;

import lotto.dto.LottoTicketDto;
import lotto.dto.WinningResultDto;
import lotto.util.ResultFormatter;

public class OutputView {
    public enum ConsoleMessage {
        TOTAL_TICKETS("%d개를 구매했습니다.%n");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public void printTickets(LottoTicketDto ticketDto) {
        System.out.printf(ConsoleMessage.TOTAL_TICKETS.message, ticketDto.totalTickets());
        ticketDto.tickets().forEach(System.out::println);
    }

    public void printWinningResult(WinningResultDto resultDto) {
        System.out.println(ResultFormatter.formatResult(resultDto.statistics()));
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}