package lotto;

import lotto.commons.lang.ProgramExitException;
import lotto.commons.logger.Logger;
import lotto.core.controller.PurchaseLottoController;
import lotto.core.controller.StartLottoGameController;
import lotto.core.service.CreateBonusLottoNumberService;
import lotto.core.service.CreateLottoPurchaseAmountService;
import lotto.core.service.CreateWinningLottoService;
import lotto.core.service.MatchWinningLottoService;
import lotto.core.service.PublishLottoTicketService;
import lotto.core.view.InputBonusLottoNumberView;
import lotto.core.view.InputLottoPurchaseAmountView;
import lotto.core.view.InputWinningLottoView;
import lotto.core.view.MatchWinningLottoView;
import lotto.core.view.PublishLottoTicketView;

public class Application {
    public static void main(String[] args) {
        Application.run(() -> {
            var purchaseLottoController = new PurchaseLottoController(
                    new InputLottoPurchaseAmountView(),
                    new PublishLottoTicketView(),
                    new CreateLottoPurchaseAmountService(),
                    new PublishLottoTicketService()
            );
            var lottoTicket = purchaseLottoController.request(null);

            var startLottoGameController = new StartLottoGameController(
                    new InputWinningLottoView(),
                    new InputBonusLottoNumberView(),
                    new MatchWinningLottoView(),
                    new CreateWinningLottoService(),
                    new CreateBonusLottoNumberService(),
                    new MatchWinningLottoService()
            );
            startLottoGameController.request(lottoTicket);
        });
    }

    private static void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (ProgramExitException e) {
            Logger.info(e.getMessage());
        } catch (Throwable e) {
            Logger.error(e);
        }
    }
}
