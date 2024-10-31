package lotto.model;

import static lotto.message.ErrorMessage.INVALID_UNIT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE;

public class LottoStore {

    public static LottoTicket purchaseLottoTicket(int purchaseAmount) {

        validateMaxPurchaseAmount(purchaseAmount);
        validateThousandWonUnit(purchaseAmount);

        int lottoCount = getLottoCount(purchaseAmount);
        return new LottoTicket(lottoCount);
    }

    private static void validateThousandWonUnit(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR_MESSAGE.getContent());
        }
    }

    private static void validateMaxPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount > 100_000) {
            throw new IllegalArgumentException(UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE.getContent());
        }
    }

    private static int getLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }
}
