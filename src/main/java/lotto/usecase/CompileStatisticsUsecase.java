package lotto.usecase;

import lotto.application.prize.dto.PrizeResponse;
import lotto.application.statistics.controller.StatisticsController;
import lotto.application.statistics.dto.StatisticsResponse;
import lotto.application.statistics.view.StatisticsOutputView;
import lotto.application.ticket.dto.TicketResponse;

public class CompileStatisticsUsecase {

    private final StatisticsOutputView outputView;
    private final StatisticsController controller;

    public CompileStatisticsUsecase(StatisticsOutputView outputView,
                                    StatisticsController controller) {

        this.outputView = outputView;
        this.controller = controller;
    }

    public void execute(TicketResponse ticketResponse, PrizeResponse prizeResponse) {
        StatisticsResponse response = controller.compile(ticketResponse, prizeResponse);

        outputView.show(response);
    }

}
