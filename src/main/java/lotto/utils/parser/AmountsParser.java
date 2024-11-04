package lotto.utils.parser;

import static lotto.constants.ErrorMessage.IS_NOT_DIVISIBLE_BY_THOUSAND_WON;
import static lotto.constants.ErrorMessage.ONLY_INTEGER_RANGE_AMOUNTS_ALLOWED;
import static lotto.constants.ErrorMessage.OVER_MAX_AMOUNTS;
import static lotto.constants.ErrorMessage.UNDER_MIN_AMOUNTS;
import static lotto.constants.LottoConstant.PURCHASABLE_MAX_AMOUNTS;
import static lotto.constants.LottoConstant.WON_1000;

public class AmountsParser {

    public static int getAmounts(String amounts) {
        int lottoAmounts;

        try {
            lottoAmounts = Integer.parseInt(amounts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_INTEGER_RANGE_AMOUNTS_ALLOWED.getMessage());
        }

        checkMinAmounts(lottoAmounts);
        checkMaxAmounts(lottoAmounts);
        checkDivisibilityByThousand(lottoAmounts);

        return lottoAmounts;
    }

    private static void checkMinAmounts(int lottoAmounts) {
        if (lottoAmounts < WON_1000) {
            throw new IllegalArgumentException(UNDER_MIN_AMOUNTS.getMessage());
        }
    }

    private static void checkMaxAmounts(int lottoAmounts) {
        if (lottoAmounts > PURCHASABLE_MAX_AMOUNTS) {
            throw new IllegalArgumentException(OVER_MAX_AMOUNTS.getMessage());
        }
    }

    private static void checkDivisibilityByThousand(int lottoAmounts) {
        if ((lottoAmounts % WON_1000) != 0) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE_BY_THOUSAND_WON.getMessage());
        }
    }
}
