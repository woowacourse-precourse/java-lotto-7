package lotto.buyer.validator;

public class MoneyValidator {
    private static final long THOUSAND = 1_000L;
    private static final long LiMIT_AMOUNT = 100_000L;
    private static final long ZERO = 0L;
    public static void validate(Long money) {
        isZero(money);
        limitAmountValidator(money);
        divisibleByThousandValidator(money);
    }
    private static void divisibleByThousandValidator(Long money) {
        if (money % THOUSAND != 0) throw new IllegalArgumentException("[ERROR]");
    }
    private static void limitAmountValidator(Long money) {
        if (money > LiMIT_AMOUNT) throw new IllegalArgumentException("[ERROR]");
    }
    private static void isZero(Long money) {
        if (money == ZERO) throw new IllegalArgumentException("[ERROR]");
    }

}
/*
  - [ x] 구매금액이 10만원을 초과할경우
   - [x] 로또 구입 금액은 1000원 단위로 입력 한다
   - [ ] 1000으로 나눠 떨어지지 않는 경우
   - [ ] 0을 입력 했을 경우
   - [ ] 숫자가 아닌 값을 입력할 경우
 */