package policy;

import validator.Validator;

public class BonusNumberPolicy {
    public void checkBonusNumberPolicy(String bonusNumber) {
        Validator.shouldBeOnlyNumber(bonusNumber);
        Validator.shouldNotBeEmpty(bonusNumber);
        Validator.moneyShouldNotBeTooBig(bonusNumber);
        Validator.shouldBeBetweenOneAndFortyFive(Integer.parseInt(bonusNumber));
    }
}
