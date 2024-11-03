package lotto;

import lotto.controller.LottoController;
import lotto.model.handler.PurchaseRequestHandler;
import lotto.model.handler.WinningLottoRequestHandler;
import lotto.service.LottoService;

public class Application {

    public static void main(String[] args) {
        PurchaseRequestHandler purchaseRequestHandler = new PurchaseRequestHandler();
        WinningLottoRequestHandler winningLottoRequestHandler = new WinningLottoRequestHandler();

        LottoService lottoGameService = new LottoService(purchaseRequestHandler, winningLottoRequestHandler);

        LottoController lottoController = new LottoController(lottoGameService);

        lottoController.run();
    }
}