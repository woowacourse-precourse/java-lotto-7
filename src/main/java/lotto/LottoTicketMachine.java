package lotto;

import lotto.controller.TicketController;
import lotto.controller.WinnerStatisticsController;
import lotto.dto.TicketResponse;
import lotto.service.prize.PrizeResponse;
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
