package lotto;

import static lotto.MoneyUtil.LOTTO_PRICE;
import static lotto.MoneyUtil.MINIMUM_PRICE;

public class MoneyValidator {
    public static void validateInputMoney(long userInputMoney) {
        if(userInputMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로만 입력해야 합니다");
        }
        if(userInputMoney < MINIMUM_PRICE) {
            throw new IllegalArgumentException("[ERROR] 0원 이상 결제해야 합니다.");
        }
    }
}
