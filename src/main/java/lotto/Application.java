package lotto;

import lotto.commons.lang.ProgramExitException;
import lotto.commons.logger.Logger;
import lotto.core.controller.PurchaseLottoController;
import lotto.core.service.CreateLottoPurchaseAmountService;
import lotto.core.service.PublishLottoService;
import lotto.core.view.InputLottoPurchaseAmountView;
import lotto.core.view.PublishLottoView;

public class Application {
    public static void main(String[] args) {
        Application.run(() -> {
            var purchaseLottoController = new PurchaseLottoController(
                    new InputLottoPurchaseAmountView(),
                    new PublishLottoView(),
                    new CreateLottoPurchaseAmountService(),
                    new PublishLottoService()
            );
            var lotto = purchaseLottoController.request(null);
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
