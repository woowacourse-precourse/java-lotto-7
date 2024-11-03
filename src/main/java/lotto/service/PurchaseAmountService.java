package lotto.service;

import lotto.entity.PurchaseAmount;
import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;

public class PurchaseAmountService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final LotteryMachineModel lotteryMachineModel;

    public PurchaseAmountService(InputValidator inputValidator, InputParser inputParser,
                                 LotteryMachineModel lotteryMachineModel) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.lotteryMachineModel = lotteryMachineModel;
    }

    public void save(String purchaseAmountInput) {
        inputValidator.validateInputIsEmpty(purchaseAmountInput);
        Long parsePurchaseAmount = inputParser.parsePurchaseAmount(purchaseAmountInput);
        PurchaseAmount purchaseAmount = new PurchaseAmount(parsePurchaseAmount);
        lotteryMachineModel.insertPurchaseAmount(purchaseAmount);
    }
}
