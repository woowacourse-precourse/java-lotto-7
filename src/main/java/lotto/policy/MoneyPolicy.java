package lotto.policy;

import lotto.validator.Validator;

public class MoneyPolicy {

    public void checkMoneyPolicy(String money) {
        // 돈은 숫자 외 다른게 입력되면 안된다.
        Validator.shouldBeOnlyNumber(money);

        // 돈에 Empty 입력되면 안된다.
        Validator.shouldNotBeEmpty(money);

        // 돈은 1000으로 나누어 떨어져야한다.
        Validator.shouldNotBeDividedBy1000(money);

        // 돈의 값이 너무 크면 안된다.(예외에서 최댓값 말해주기)
        Validator.shouldNotBeTooBig(money);
    }


}
