package policy;

import model.Lotto;
import validator.Validator;

public class BonusNumberPolicy {
    public void checkBonusNumberPolicy(String bonusNumber, Lotto winningLotto) {
        Validator.shouldBeOnlyNumber(bonusNumber);
        Validator.shouldNotBeEmpty(bonusNumber);
        Validator.shouldNotBeTooBig(bonusNumber);
        Validator.shouldBeBetweenOneAndFortyFive(Integer.parseInt(bonusNumber));
        Validator.shouldNotOverlap(winningLotto, bonusNumber);
    }
}
