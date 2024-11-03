package lotto.service;

import lotto.entity.BonusNumber;
import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;

public class BonusNumberService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final LotteryMachineModel lotteryMachineModel;

    public BonusNumberService(InputValidator inputValidator, InputParser inputParser,
                              LotteryMachineModel lotteryMachineModel) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.lotteryMachineModel = lotteryMachineModel;
    }

    public void save(String input) {
        inputValidator.validateInputIsEmpty(input);
        Integer parseNumber = inputParser.parseBonusAmount(input);
        BonusNumber bonusNumber = new BonusNumber(parseNumber);
        lotteryMachineModel.settingBonusNumber(bonusNumber);
    }
}
