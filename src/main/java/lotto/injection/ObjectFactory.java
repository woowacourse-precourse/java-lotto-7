package lotto.injection;

import lotto.controller.PurchaseAmountController;
import lotto.parse.InputParser;
import lotto.service.PurchaseAmountService;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ObjectFactory {

    public PurchaseAmountController purchaseAmountController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new PurchaseAmountController(inputView, outputView, purchaseAmountService());
    }

    public PurchaseAmountService purchaseAmountService() {
        InputValidator inputValidator = new InputValidator();
        InputParser inputParser = new InputParser();
        return new PurchaseAmountService(inputValidator, inputParser);
    }
}
