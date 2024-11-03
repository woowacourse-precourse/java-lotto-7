package lotto.domain.buyer;

import static lotto.domain.buyer.LottosCount.from;
import static lotto.resources.ErrorMessages.LOTTOS_COUNT_MISMATCH_CUSTOM_LOTTOS_SIZE;

import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottosFactory;

public class BuyerFactory {

    public static Buyer createBuyer(final int purchaseMoney) {
        final LottosCount LottosCount = from(purchaseMoney);

        final Lottos buyLottos = LottosFactory.generateRandomLottos(LottosCount);

        return new Buyer(LottosCount, buyLottos);
    }

    public static Buyer createTestBuyer(final int purchaseMoney, final Lottos customLottos) {
        final LottosCount LottosCount = from(purchaseMoney);
        validateLottosCount(LottosCount, customLottos);
        return new Buyer(LottosCount, customLottos);
    }

    private static void validateLottosCount(final LottosCount lottosCount, final Lottos customLottos) {
        if (lottosCount.getLottosCount() != customLottos.getLottosSize()) {
            throw new IllegalArgumentException(LOTTOS_COUNT_MISMATCH_CUSTOM_LOTTOS_SIZE.getMessage());
        }
    }
}
