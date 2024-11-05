package lotto.policy;

import lotto.model.Lotto;
import lotto.validator.Validator;

public class BonusNumberPolicy {
    public void checkBonusNumberPolicy(String bonusNumber, Lotto winningLotto) {
        Validator.shouldBeOnlyNumber(bonusNumber);
        Validator.shouldNotBeEmpty(bonusNumber);
        Validator.shouldNotBeTooBig(bonusNumber);
        Validator.shouldBeBetweenOneAndFortyFive(Integer.parseInt(bonusNumber));
        Validator.shouldNotOverlap(winningLotto, bonusNumber);
    }
}
