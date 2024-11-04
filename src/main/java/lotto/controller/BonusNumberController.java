package lotto.controller;

import lotto.dto.BonusNumberDto;
import lotto.service.BonusNumberService;
import lotto.validator.BonusNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class BonusNumberController {

    private final BonusNumberService bonusNumberService = new BonusNumberService();

    public void getBonusNumber() {
        try {
            String input = InputView.inputBonusNumber();
            BonusNumberDto dto = BonusNumberValidator.validate(input);
            bonusNumberService.saveBonusNumber(dto);

        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getBonusNumber();
        }
    }
}
