package lotto.controller;

import lotto.constant.OutputMessage;
import lotto.model.PurchasePrice;
import lotto.service.InputParsingService;
import lotto.service.InputValidationService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidationService inputValidationService;
    private final InputParsingService inputParsingService;

    public LottoController(
            InputView inputView,
            OutputView outputView,
            InputValidationService inputValidationService,
            InputParsingService inputParsingService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidationService = inputValidationService;
        this.inputParsingService = inputParsingService;
    }

    public void runLotto() {
        PurchasePrice purchasePrice = inputPurchasePrice();
    }

    private PurchasePrice inputPurchasePrice() {
        outputView.printMessage(OutputMessage.PURCHASE_PRICE_INPUT_MESSAGE);
        String rawPurchasePrice = inputView.inputContent();
        inputValidationService.validatePurchasePrice(rawPurchasePrice);
        return inputParsingService.parsePurchasePrice(rawPurchasePrice);
    }
}
