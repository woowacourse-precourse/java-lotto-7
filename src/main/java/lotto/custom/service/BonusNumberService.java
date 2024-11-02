package lotto.custom.service;

import java.util.List;
import lotto.custom.validator.InputValidator;

public class BonusNumberService {
    private final InputValidator inputValidator;

    public BonusNumberService() {
        this.inputValidator = new InputValidator();
    }

    public int run(List<Integer> winningNumbers, String bonusNumberInput) {
        inputValidator.validateBonusNumberInput(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput.trim());
        inputValidator.validateBonusNumbers(winningNumbers, bonusNumber);
        return bonusNumber;
    }
}