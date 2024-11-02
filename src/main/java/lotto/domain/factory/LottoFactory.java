package lotto.domain.factory;

import static lotto.config.ErrorMessageConstant.PURCHASE_REMINDER_MESSAGE;
import static lotto.config.ErrorMessageConstant.PURCHASE_TOO_LOW_MESSAGE;
import static lotto.config.GameConstant.PRICE_OF_LOTTO;

public class LottoFactory {
    private LottoFactory() {
    }

    public static void generateLotto(int purchase) {
        validatePurcahse(purchase);
    }

    private static void validatePurcahse(int purchase) {
        if (purchase < PRICE_OF_LOTTO) {
            throw new IllegalArgumentException(PURCHASE_TOO_LOW_MESSAGE);
        }

        if (purchase % PRICE_OF_LOTTO != 0) {
            throw new IllegalArgumentException(PURCHASE_REMINDER_MESSAGE);
        }
    }
}
