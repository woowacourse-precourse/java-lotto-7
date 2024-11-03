package lotto;

import java.util.List;
import lotto.commons.beans.BeanFactory;
import lotto.commons.lang.InputOverFlowException;
import lotto.commons.lang.ProgramExitException;
import lotto.commons.logger.Logger;
import lotto.core.controller.Controller;
import lotto.core.controller.PurchaseLottoController;
import lotto.core.controller.StartLottoGameController;
import lotto.core.controller.request.StartLottoGameRequest;
import lotto.core.controller.request.StartLottoGameRequest.LottoPurchaseAmountRequest;
import lotto.core.controller.request.StartLottoGameRequest.LottoRequest;
import lotto.core.controller.request.VoidRequest;
import lotto.core.controller.response.PurchaseLottoResponse;
import lotto.core.controller.response.PurchaseLottoResponse.LottoPurchaseAmountResponse;
import lotto.core.controller.response.VoidResponse;

public class Application {
    public static void main(String[] args) {
        Application.run(() -> {
            Controller<VoidRequest, PurchaseLottoResponse> purchaseLottoController = BeanFactory.getBean(PurchaseLottoController.class);
            PurchaseLottoResponse purchaseLottoResponse = purchaseLottoController.request(VoidRequest.type());

            LottoPurchaseAmountResponse amountResponse = purchaseLottoResponse.amount();
            LottoPurchaseAmountRequest amountRequest = new LottoPurchaseAmountRequest(amountResponse.value(), amountResponse.lottoCount());
            List<LottoRequest> lottoRequests = purchaseLottoResponse.lottos().stream()
                    .map(it -> new LottoRequest(it.numbers()))
                    .toList();
            StartLottoGameRequest startLottoGameRequest = new StartLottoGameRequest(amountRequest, lottoRequests);

            Controller<StartLottoGameRequest, VoidResponse> startLottoGameController = BeanFactory.getBean(StartLottoGameController.class);
            startLottoGameController.request(startLottoGameRequest);
        });
    }

    private static void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (ProgramExitException e) {
            Logger.info(e.getMessage());
        } catch (InputOverFlowException e) {
            Logger.error(e.getMessage());
        } catch (Throwable e) {
            Logger.error(e);
        }
    }
}
