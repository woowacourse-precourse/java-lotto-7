package lotto.injection;

import lotto.controller.BonusNumberController;
import lotto.controller.LotteryMachineController;
import lotto.controller.PurchaseAmountController;
import lotto.controller.WinnerNumberController;
import lotto.model.LotteryMachineModel;
import lotto.model.StatisticModel;
import lotto.parse.InputParser;
import lotto.service.BonusNumberService;
import lotto.service.LotteryMachineService;
import lotto.service.PurchaseAmountService;
import lotto.service.WinnerNumberService;
import lotto.validation.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ObjectFactory {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final InputValidator inputValidator = new InputValidator();
    private final InputParser inputParser = new InputParser();
    private final LotteryMachineModel lotteryMachineModel = new LotteryMachineModel();
    private final StatisticModel statisticModel = new StatisticModel();

    public final PurchaseAmountController purchaseAmountController() {
        return new PurchaseAmountController(inputView, outputView, purchaseAmountService(), lotteryMachineService());
    }

    public final WinnerNumberController winnerNumberController() {
        return new WinnerNumberController(inputView, outputView, winnerNumberService());
    }

    public final BonusNumberController bonusNumberController() {
        return new BonusNumberController(inputView, outputView, bonusNumberService());
    }

    public final LotteryMachineController lotteryMachineController() {
        return new LotteryMachineController(outputView, lotteryMachineService());
    }

    public final PurchaseAmountService purchaseAmountService() {
        return new PurchaseAmountService(inputValidator, inputParser, lotteryMachineModel);
    }

    public final WinnerNumberService winnerNumberService() {
        return new WinnerNumberService(inputValidator, inputParser, lotteryMachineModel);
    }

    public final BonusNumberService bonusNumberService() {
        return new BonusNumberService(inputValidator, inputParser, lotteryMachineModel);
    }

    public final LotteryMachineService lotteryMachineService() {
        return new LotteryMachineService(lotteryMachineModel, statisticModel);
    }
}
