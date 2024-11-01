package lotto.service;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;

public class LottoPurchaseServiceImpl implements LottoPurchaseService {
    private final LottoFactory defaultLottoFactory;
    private Lottos lottos;

    public LottoPurchaseServiceImpl(LottoFactory defaultLottoFactory) {
        this.defaultLottoFactory = defaultLottoFactory;
    }


    @Override
    public void buyLottos(int purchaseAmount) {
        int purchasedLottoCount = getLottoCount(purchaseAmount);
        lottos = Lottos.createLottos(purchasedLottoCount, defaultLottoFactory);
    }


    private static int getLottoCount( int purchaseAmount ) {
        return purchaseAmount / LOTTO_PRICE.getValue();
    }
}
