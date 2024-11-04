package lotto.usecase.config;

import lotto.application.prize.config.PrizeAppConfig;
import lotto.application.prize.controller.BonusController;
import lotto.application.prize.controller.WinnerController;
import lotto.application.prize.service.CreateBonusNumberService;
import lotto.application.prize.service.CreateWinnerNumbersService;
import lotto.application.prize.view.input.BonusInputView;
import lotto.application.prize.view.input.WinnerInputView;
import lotto.application.statistics.config.StatisticsAppConfig;
import lotto.application.statistics.view.StatisticsOutputView;
import lotto.application.ticket.config.TicketAppConfig;
import lotto.application.ticket.view.input.TicketInputView;
import lotto.application.ticket.view.output.TicketOutputView;
import lotto.usecase.CompileStatisticsUsecase;
import lotto.usecase.CreatePrizeUsecase;
import lotto.usecase.CreateTicketUsecase;
import lotto.usecase.prize.CreateBonusNumberUsecase;
import lotto.usecase.prize.CreateWinnerNumbersUsecase;

public class UsecaseConfig {

    public static CreateTicketUsecase getCreateTicketUsecase() {
        return new CreateTicketUsecase(
                new TicketInputView(),
                new TicketOutputView(),
                new TicketAppConfig().getTicketController()
        );
    }

    public static CreateBonusNumberUsecase getCreateBonusNumberUsecase() {
        return new CreateBonusNumberUsecase(
                new BonusInputView(),
                new BonusController(
                        new CreateBonusNumberService()
                )
        );
    }

    public static CreateWinnerNumbersUsecase getCreateWinnerNumbersUsecase() {
        return new CreateWinnerNumbersUsecase(
                new WinnerInputView(),
                new WinnerController(
                        new CreateWinnerNumbersService()
                )
        );
    }

    public static CreatePrizeUsecase getCreatePrizeUsecase() {
        return new CreatePrizeUsecase(
                getCreateWinnerNumbersUsecase(),
                getCreateBonusNumberUsecase(),
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
