package lotto.controller;

import lotto.dto.BonusNumberRequestDto;
import lotto.handler.BonusNumberHandler;
import lotto.view.InputView;

public class BonusNumberController {
    public static BonusNumberRequestDto run() {
        String bonusNumber = "";
        boolean isValid = false;
        while (!isValid) {
            bonusNumber = InputView.requestBonusNumber();
            isValid = BonusNumberHandler.handle(bonusNumber);
        }
        return new BonusNumberRequestDto(Integer.parseInt(bonusNumber));
    }
}
