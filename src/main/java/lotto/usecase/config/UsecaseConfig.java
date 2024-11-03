package lotto.usecase.config;

import lotto.application.prize.config.PrizeAppConfig;
import lotto.application.prize.view.input.PrizeInputView;
import lotto.application.statistics.config.StatisticsAppConfig;
import lotto.application.statistics.view.StatisticsOutputView;
import lotto.application.ticket.config.TicketAppConfig;
import lotto.application.ticket.view.input.TicketInputView;
import lotto.application.ticket.view.output.TicketOutputView;
import lotto.usecase.CompileStatisticsUsecase;
import lotto.usecase.CreatePrizeUsecase;
import lotto.usecase.CreateTicketUsecase;

public class UsecaseConfig {

    public static CreateTicketUsecase getCreateTicketUsecase() {
        return new CreateTicketUsecase(
                new TicketInputView(),
                new TicketOutputView(),
                new TicketAppConfig().getTicketController()
        );
    }

    public static CreatePrizeUsecase getCreatePrizeUsecase() {
        return new CreatePrizeUsecase(
                new PrizeInputView(),
                new PrizeAppConfig().getPrizeController()
        );
    }

    public static CompileStatisticsUsecase getCompileStatisticsUsecase() {
        return new CompileStatisticsUsecase(
                new StatisticsOutputView(),
                new StatisticsAppConfig().getStatisticsController()
        );
    }
}
