package lotto;

import lotto.application.prize.dto.PrizeResponse;
import lotto.application.ticket.dto.TicketResponse;
import lotto.usecase.CompileStatisticsUsecase;
import lotto.usecase.CreatePrizeUsecase;
import lotto.usecase.CreateTicketUsecase;

public class LottoTicketMachine {

    private final CreateTicketUsecase createTicketUsecase;
    private final CreatePrizeUsecase createPrizeUsecase;
    private final CompileStatisticsUsecase compileStatisticsUsecase;

    public LottoTicketMachine(
            CreateTicketUsecase createTicketUsecase,
            CreatePrizeUsecase createPrizeUsecase,
            CompileStatisticsUsecase compileStatisticsUsecase) {

        this.createTicketUsecase = createTicketUsecase;
        this.createPrizeUsecase = createPrizeUsecase;
        this.compileStatisticsUsecase = compileStatisticsUsecase;
    }

    public void run() {
        TicketResponse ticketResponse = createTicketUsecase.execute();
        PrizeResponse prizeResponse = createPrizeUsecase.execute();

        compileStatisticsUsecase.execute(ticketResponse, prizeResponse);
    }

}
