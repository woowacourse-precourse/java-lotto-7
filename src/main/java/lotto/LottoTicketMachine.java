package lotto;

import lotto.application.prize.service.PrizeResponse;
import lotto.application.statistics.controller.WinnerStatisticsController;
import lotto.application.ticket.dto.TicketResponse;
import lotto.usecase.CreatePrizeUsecase;
import lotto.usecase.CreateTicketUsecase;

public class LottoTicketMachine {

    private final CreateTicketUsecase createTicketUsecase;
    private final CreatePrizeUsecase createPrizeUsecase;
    private final WinnerStatisticsController winStatisticsController;

    public LottoTicketMachine(
            CreateTicketUsecase createTicketUsecase,
            CreatePrizeUsecase createPrizeUsecase,
            WinnerStatisticsController winStatisticsController) {

        this.createTicketUsecase = createTicketUsecase;
        this.createPrizeUsecase = createPrizeUsecase;
        this.winStatisticsController = winStatisticsController;
    }

    public void run() {
        TicketResponse ticketResponse = createTicketUsecase.execute();
        PrizeResponse winnerNumbers = createPrizeUsecase.execute();
        winStatisticsController.create(ticketResponse, winnerNumbers);
    }

}
