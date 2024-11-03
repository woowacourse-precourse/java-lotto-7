package lotto.domain;

import java.util.List;

public class LottoMarket {
    private static final int LOTTO_PRICE = 1000;
    private final LottoFactory lottoFactory;

    public LottoMarket(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public List<Lotto> sellLottos(int amount) {
        int lottoQuantity = purchasableLottoQuantity(amount);
        return lottoFactory.createAllLottos(lottoQuantity);
    }

    private int purchasableLottoQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }

}
