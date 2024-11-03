package lotto.util;

import lotto.model.Lotto;

public class LottoException {
    public static void checkInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 정수가 아니거나 처리할 수 없는 범위의 정수를 입력 받았습니다.");
        }
    }

    public static void checkPurchaseRange(int number) {
        if (number < 1000 || number > 100000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000이상 100,000이하여의 정수여야 합니다.");
        }
    }

    public static void checkRoundThousand(int number) {
        if ((number / 1000) * 1000 != number) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }

    public static void checkNumberRange(int number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1이상 45이하여야 합니다.");
        }
    }

    public static void checkContainBonus(Lotto lotto, int bonus) {
        if (lotto.checkHit(bonus)) {
            throw new IllegalArgumentException("[ERROR] 입력받은 당첨 번호에 이미 포함된 수입니다.");
        }
    }
}
