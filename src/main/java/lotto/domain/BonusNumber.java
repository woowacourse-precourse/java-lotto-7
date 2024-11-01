package lotto.domain;

import java.util.List;
import lotto.util.ParseUtil;
import lotto.validator.BonusNumberValidator;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        BonusNumberValidator.validateBonusNumber(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber createBonusNumber(List<Integer> winningNumbers, String input) {
        BonusNumberValidator.validateInputBonusNumber(input);
        return new BonusNumber(winningNumbers, ParseUtil.parseInt(input));
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
