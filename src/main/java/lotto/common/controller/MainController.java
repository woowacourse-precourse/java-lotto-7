package lotto.common.controller;

import java.util.List;
import lotto.common.controller.handler.ConsoleInputHandler;
import lotto.common.controller.handler.ConsoleOutputHandler;
import lotto.lotto.controller.LottoController;
import lotto.lotto.domain.LottoResults;
import lotto.purchase.controller.PurchaseController;
import lotto.purchase.domain.Purchase;
import lotto.purchase.domain.PurchaseResult;

public class MainController {

    private final LottoController lottoController;
    private final PurchaseController purchaseController;
    private final ConsoleInputHandler inputHandler;
    private final ConsoleOutputHandler outputHandler;

    public MainController(LottoController lottoController, PurchaseController purchaseController,
                          ConsoleInputHandler inputHandler, ConsoleOutputHandler outputHandler) {
        this.lottoController = lottoController;
        this.purchaseController = purchaseController;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void control() {
        long moneyValue = promptForMoneyInput();
        Purchase purchase = processLottoPurchase(moneyValue);

        setupWinningLotto(purchase.getLottoResultId());
        displayLottoResult(purchase.getId());
    }

    private long promptForMoneyInput() {
        outputHandler.printMoneyPromptMessage();
        return inputHandler.inputMoney();
    }

    private Purchase processLottoPurchase(long moneyValue) {
        Purchase purchase = purchaseController.createPurchase(moneyValue);
        outputHandler.printBuyingLottoMessage(purchase.getMoney().getQuantitiesCanBuy());
        LottoResults lottosInfo = lottoController.getLottosInfo(purchase.getLottoResultId());
        outputHandler.printGeneratedLottos(lottosInfo);
        return purchase;
    }

    private void setupWinningLotto(String lottoResultId) {
        List<Integer> numbers = promptForWinningNumbers();
        int bonusNumber = promptForBonusNumber();
        lottoController.createWinningLotto(lottoResultId, numbers, bonusNumber);
    }

    private List<Integer> promptForWinningNumbers() {
        outputHandler.printWinningLottoMessage();
        return inputHandler.inputWinningLotto();
    }

    private int promptForBonusNumber() {
        outputHandler.printBonusNumberMessage();
        return inputHandler.inputBonusNumber();
    }

    private void displayLottoResult(String purchaseId) {
        PurchaseResult purchaseResult = purchaseController.getPurchaseResult(purchaseId);
        outputHandler.printResultMessage(purchaseResult);
    }
}