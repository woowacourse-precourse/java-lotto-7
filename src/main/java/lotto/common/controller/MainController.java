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
        Purchase purchaseInput = promptForMoneyInput();
        Purchase purchase = processLottoPurchase(purchaseInput);

        setupWinningLotto(purchase.getLottoResultId());
        displayLottoResult(purchase.getId());
    }

    private Purchase promptForMoneyInput() {
        while (true) {
            try {
                outputHandler.printMoneyPromptMessage();
                long moneyValue = inputHandler.inputMoney();
                return purchaseController.createPurchase(moneyValue);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Purchase processLottoPurchase(Purchase purchase) {
        outputHandler.printBuyingLottoMessage(purchase.getMoney().getQuantitiesCanBuy());
        LottoResults lottosInfo = lottoController.getLottosInfo(purchase.getLottoResultId());
        outputHandler.printGeneratedLottos(lottosInfo);
        return purchase;
    }

    private LottoResults setupWinningLotto(String lottoResultId) {
        while (true) {
            try {
                List<Integer> numbers = promptForWinningNumbers();
                int bonusNumber = promptForBonusNumber();
                return lottoController.createWinningLotto(lottoResultId, numbers, bonusNumber);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
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