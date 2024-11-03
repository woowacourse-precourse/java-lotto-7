package lotto.view;

import lotto.model.draw.LottoNumbersGenerator;
import lotto.model.lotto.LottoTickets;
import lotto.model.result.WinningStatistics;

public class OutputView {

    public enum ConsoleMessage {
        TOTAL_TICKETS("%d개를 구매했습니다.");
        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }
    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printTicketNumber(int totalTickets) {
        System.out.printf(ConsoleMessage.TOTAL_TICKETS.message, totalTickets);
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        for (LottoNumbersGenerator lottoNumbers : lottoTickets.getLottoTickets()) {
            System.out.println(lottoNumbers.getLottoNumbers());
        }
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(winningStatistics.toString());
    }

}
