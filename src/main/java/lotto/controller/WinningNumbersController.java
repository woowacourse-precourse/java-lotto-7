package lotto.controller;

import lotto.dto.WinningNumbersDto;
import lotto.service.WinningNumberService;
import lotto.validator.WinningNumbersValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class WinningNumbersController {
    private final WinningNumberService winningNumberService = new WinningNumberService();

    public void getWinningNumbers() {
        try {
            String input = InputView.inputWinningNumbers();
            WinningNumbersDto dto = WinningNumbersValidator.validate(input);
            winningNumberService.save(dto);

        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getWinningNumbers();
        }
    }
}
