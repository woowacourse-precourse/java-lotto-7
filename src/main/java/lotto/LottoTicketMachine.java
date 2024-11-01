package lotto;

import lotto.controller.TicketController;
import lotto.controller.WinnerNumberController;
import lotto.controller.WinnerStatisticsController;
import lotto.dto.TicketResult;

public class LottoTicketMachine {

    private final TicketController ticketController;
    private final WinnerNumberController winNumberController;
    private final WinnerStatisticsController winStatisticsController;

    public LottoTicketMachine(TicketController ticketController,
                              WinnerNumberController winNumberController,
                              WinnerStatisticsController winStatisticsController) {

        this.ticketController = ticketController;
        this.winNumberController = winNumberController;
        this.winStatisticsController = winStatisticsController;
    }

    public void run() {
        TicketResult ticketResult = ticketController.create();
        WinnerNumber winnerNumber = winNumberController.create();
        winStatisticsController.create(ticketResult, winnerNumber);
    }

}
