package lotto;

import lotto.controller.LottoController;
import lotto.model.handler.PurchaseRequestHandler;
import lotto.model.handler.WinningNumbersRequestHandler;
import lotto.service.InputService;
import lotto.service.LottoService;

public class Application {

    public static void main(String[] args) {
        PurchaseRequestHandler purchaseRequestHandler = new PurchaseRequestHandler();
        WinningNumbersRequestHandler winningNumbersRequestHandler = new WinningNumbersRequestHandler();

        InputService inputService = new InputService();
        LottoService lottoGameService = new LottoService(purchaseRequestHandler,
                winningNumbersRequestHandler);

        LottoController lottoController = new LottoController(inputService, lottoGameService);
        lottoController.run();
    }

}