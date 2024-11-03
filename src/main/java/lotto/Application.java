package lotto;

import lotto.controller.LottoController;
import lotto.model.handler.PurchaseRequestHandler;
import lotto.model.handler.WinningNumbersAndBonusNumberRequestHandler;
import lotto.service.LottoService;

public class Application {

    public static void main(String[] args) {
        PurchaseRequestHandler purchaseRequestHandler = new PurchaseRequestHandler();
        WinningNumbersAndBonusNumberRequestHandler winningNumbersAndBonusNumberRequestHandler = new WinningNumbersAndBonusNumberRequestHandler();

        LottoService lottoGameService = new LottoService(purchaseRequestHandler,
                winningNumbersAndBonusNumberRequestHandler);

        LottoController lottoController = new LottoController(lottoGameService);

        lottoController.run();
    }
}