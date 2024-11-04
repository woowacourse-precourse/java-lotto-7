package lotto.policy;

import lotto.validator.Validator;

public class MoneyPolicy {
    public void checkMoneyPolicy(String money) {
        Validator.shouldBeOnlyNumber(money);
        Validator.shouldNotBeEmpty(money);
        Validator.shouldNotBeDividedBy1000(money);
        Validator.shouldNotBeTooBig(money);
    }


}
