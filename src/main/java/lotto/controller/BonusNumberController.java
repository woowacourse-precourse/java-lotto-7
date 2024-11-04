package lotto.controller;

import lotto.dto.BonusNumberRequestDto;
import lotto.dto.WinningNumbersRequestDto;
import lotto.service.handler.BonusNumberHandler;
import lotto.view.InputView;

public class BonusNumberController {
    public static BonusNumberRequestDto run(WinningNumbersRequestDto winningNumbersRequestDto) {
        String bonusNumber = "";
        boolean isValid = false;
        while (!isValid) {
            bonusNumber = InputView.requestBonusNumber();
            isValid = BonusNumberHandler.handle(bonusNumber, winningNumbersRequestDto);
        }
        return new BonusNumberRequestDto(Integer.parseInt(bonusNumber));
    }
}
