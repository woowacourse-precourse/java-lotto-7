package lotto.usecase.config;

import lotto.application.prize.config.PrizeAppConfig;
import lotto.application.statistics.config.StatisticsAppConfig;
import lotto.application.statistics.view.StatisticsOutputView;
import lotto.application.ticket.config.TicketAppConfig;
import lotto.application.ticket.view.input.TicketInputView;
import lotto.application.ticket.view.output.TicketOutputView;
import lotto.usecase.CompileStatisticsUsecase;
import lotto.usecase.CreatePrizeUsecase;
import lotto.usecase.CreateTicketUsecase;
import lotto.usecase.nneew.bonus.BonusController;
import lotto.usecase.nneew.bonus.BonusInputView;
import lotto.usecase.nneew.bonus.CreateBonusNumberService;
import lotto.usecase.nneew.bonus.CreateBonusNumberUsecase;
import lotto.usecase.nneew.winner.CreateWinnerNumbersService;
import lotto.usecase.nneew.winner.CreateWinnerNumbersUsecase;
import lotto.usecase.nneew.winner.WinnerController;
import lotto.usecase.nneew.winner.WinnerInputView;

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
