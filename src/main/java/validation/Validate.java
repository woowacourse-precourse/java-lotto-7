package validation;

import static constant.Constant.MAX_LOTTO_NUMBER;
import static constant.Constant.MAX_LOTTO_PRICE;
import static constant.Constant.MIN_LOTTO_NUMBER;
import static constant.Constant.MIN_LOTTO_PRICE;

import lotto.Lotto;

public class Validate {
    // 보너스 번호가 로또 번호와 중복되는 숫자가 있는지 검증하는 메서드
    public static void checkBonusNumberRedundancy(int number, Lotto lotto) {
        for (Integer lottoNumber : lotto.getNumbers()) {
            if (lottoNumber == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복되지 않아야 합니다.");
            }
        }
    }

    // 보너스 번호가 1~45 사이의 숫자를 입력했는지 검증하는 메서드
    public static void checkBonusNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이여야 합니다.");
        }
    }

    // 100,000원을 초과했는지 확인하는 메서드
    public static void checkPurchasedAmountExceeded(int purchaseAmount) {
        if (purchaseAmount > MAX_LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1인당 100,000원을 넘길 수 없습니다.");
        }
    }

    // 1,000원 단위인지 확인하는 메서드
    public static void checkUnitOfPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % MIN_LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 양수인지 확인하는 메서드
    public static String checkPositiveNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자(양수)여야 합니다.");
        }
        return input;
    }
}
