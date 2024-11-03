package lotto;

import lotto.application.prize.service.PrizeResponse;
import lotto.application.statistics.controller.WinnerStatisticsController;
import lotto.application.ticket.controller.TicketController;
import lotto.application.ticket.dto.TicketResponse;
import lotto.usecase.CreatePrizeUsecase;

public class LottoTicketMachine {

    private final TicketController ticketController;
    private final CreatePrizeUsecase createPrizeUsecase;
    private final WinnerStatisticsController winStatisticsController;

    public LottoTicketMachine(TicketController ticketController,
                              CreatePrizeUsecase createPrizeUsecase,
                              WinnerStatisticsController winStatisticsController) {

        this.ticketController = ticketController;
        this.createPrizeUsecase = createPrizeUsecase;
        this.winStatisticsController = winStatisticsController;
    }

    public void run() {
        TicketResponse ticketResponse = ticketController.create();
        PrizeResponse winnerNumbers = createPrizeUsecase.execute();
        winStatisticsController.create(ticketResponse, winnerNumbers);
    }

}
