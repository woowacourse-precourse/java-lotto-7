package lotto.service;

import java.util.List;
import lotto.entity.WinnerNumber;
import lotto.model.LotteryMachineModel;
import lotto.parse.InputParser;
import lotto.validation.InputValidator;

public class WinnerNumberService {

    private final InputValidator inputValidator;
    private final InputParser inputParser;
    private final LotteryMachineModel lotteryMachineModel;

    public WinnerNumberService(InputValidator inputValidator, InputParser inputParser,
                               LotteryMachineModel lotteryMachineModel) {
        this.inputValidator = inputValidator;
        this.inputParser = inputParser;
        this.lotteryMachineModel = lotteryMachineModel;
    }

    public void save(String input) {
        validateInput(input);
        List<Integer> parseNumbers = inputParser.parseWinnerNumber(input);
        WinnerNumber winnerNumber = new WinnerNumber(parseNumbers);
        lotteryMachineModel.settingWinnerNumber(winnerNumber);
    }

    private void validateInput(String input) {
        inputValidator.validateInputIsEmpty(input);
        inputValidator.validateValidCharacter(input);
    }
}
