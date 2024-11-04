package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static void checkBuyAmountMatchLottoPrice(Integer amount) {
        if (amount % 1000 != 0) {
            ErrorException.runError("로또 구매 금액은 1000원으로 나누어 떨어지도록 해야합니다.");
        }
    }

    public static void checkIntegerPositive(Integer amount, String errorMessage) {
        if (amount < 0) {
            ErrorException.runError(errorMessage);
        }
    }

    public static void checkBuyAmountValidate(Integer amount) {
        checkIntegerPositive(amount, "로또 구매 금액은 양수여야 합니다.");
        checkBuyAmountMatchLottoPrice(amount);
    }

    public static void checkNumberInLottoRange(Integer integer) {
        if (integer > 45) {
            ErrorException.runError("로또 숫자는 1~45범위 이내여야 합니다.");
        }
    }

    public static void checkWinNumbersValidate(List<Integer> winNumbers) {
        Set<Integer> set = new HashSet<Integer>(winNumbers);
        if (set.size() != 6) {
            ErrorException.runError("중복 없이 6개의 숫자를 입력해야 합니다.");
        }

        for (Integer winNumber : winNumbers) {
            checkALottoNumberValidate(winNumber);
        }
    }

    public static void checkALottoNumberValidate(Integer winNumber) {
        checkIntegerPositive(winNumber, "당첨 번호는 양수여야 합니다.");
        checkNumberInLottoRange(winNumber);
    }
}
