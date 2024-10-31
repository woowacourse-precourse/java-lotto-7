package lotto.model;

import static lotto.message.ErrorMessage.INVALID_UNIT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static LottoTicket purchaseLottoTicket(int purchaseAmount) {

        validateMaxPurchaseAmount(purchaseAmount);
        validateThousandWonUnit(purchaseAmount);

        int lottoCount = getLottoCount(purchaseAmount);
        return createLottoTicket(lottoCount);
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

    private static LottoTicket createLottoTicket(int lottoCount) {
       List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        return new LottoTicket(lottos);
    }
}
