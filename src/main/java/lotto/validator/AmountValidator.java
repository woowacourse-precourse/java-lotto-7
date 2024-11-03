package lotto.validator;

import lotto.enums.LottoConfig;

public class AmountValidator {

    public static void amountIsNum(String inputAmount) {
        try {
            Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자만 가능 합니다.");
        }
    }

    public static void amountDivide(Integer amount) {
        if ((amount % LottoConfig.LOTTO_PRICE.getValue()) != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }

    public static void amountMinus(Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수만 가능 합니다");
        }
    }
}
