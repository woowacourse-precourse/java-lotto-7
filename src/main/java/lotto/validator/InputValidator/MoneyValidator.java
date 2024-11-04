package lotto.validator.InputValidator;


import java.math.BigInteger;
import lotto.validator.ValidatorUtils;

public class MoneyValidator implements InputValidator<Integer> {
    @Override
    public Integer validate(String input) {
        BigInteger bigIntValue = ValidatorUtils.validateBigInteger(input);  // 숫자 형식 검증 및 BigInteger 변환
        int money = ValidatorUtils.validateIntRange(bigIntValue);           // int 범위 검증
        checkMoney(money);
        return money;
    }

    // 금액 검증
    private void checkMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 음수가 될 수 없습니다.");
        }
        if (money == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력 금액이 0원입니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 1,000원 단위여야 합니다.");
        }
    }
}


