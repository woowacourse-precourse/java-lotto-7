package lotto.domain;


import lotto.util.Validator;

import java.util.List;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int bonusNumber, List<Integer> winningNumbers) {
        Validator.validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}