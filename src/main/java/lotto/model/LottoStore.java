package lotto.model;

import static lotto.message.ErrorMessage.INVALID_UNIT_ERROR_MESSAGE;
import static lotto.message.ErrorMessage.UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int UNIT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 100_000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_MAX_COUNT = 6;


    public static LottoTicket purchaseLottoTicket(int purchaseAmount) {

        validateMaxPurchaseAmount(purchaseAmount);
        validateThousandWonUnit(purchaseAmount);

        int lottoCount = getLottoCount(purchaseAmount);
        return createLottoTicket(lottoCount);
    }

    private static void validateThousandWonUnit(int purchaseAmount) {
        if (purchaseAmount % UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR_MESSAGE.getContent());
        }
    }

    private static void validateMaxPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(UPPER_LIMIT_EXCEEDED_ERROR_MESSAGE.getContent());
        }
    }

    private static int getLottoCount(int purchaseAmount) {
        return purchaseAmount / UNIT;
    }

    private static LottoTicket createLottoTicket(int lottoCount) {
       List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_MAX_COUNT);
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }
        return new LottoTicket(lottos);
    }
}
