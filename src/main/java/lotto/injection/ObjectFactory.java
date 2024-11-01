package lotto.injection;

import lotto.controller.PurchaseAmountController;
import lotto.controller.WinnerNumberController;
import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.service.PurchaseAmountService;
import lotto.service.WinnerNumberService;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ObjectFactory {

    private final InputValidator inputValidator = new InputValidator();

    public final PurchaseAmountController purchaseAmountController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new PurchaseAmountController(inputView, outputView, purchaseAmountService());
    }

    public final WinnerNumberController winnerNumberController() {
        InputView inputView = new InputView();
        return new WinnerNumberController(inputView, winnerNumberService());
    }

    public final PurchaseAmountService purchaseAmountService() {
        InputParser inputParser = new InputParser();
        LotteryMachineModel lotteryMachineModel = new LotteryMachineModel();
        return new PurchaseAmountService(inputValidator, inputParser, lotteryMachineModel);
    }

    public final WinnerNumberService winnerNumberService() {
        return new WinnerNumberService(inputValidator);
    }
}
