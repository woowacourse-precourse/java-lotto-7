package lotto.domain;

import static lotto.constant.Error.MAX_AMOUNT_PURCHASE;
import static lotto.constant.Error.MIN_AMOUNT_PURCHASE;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;
import static lotto.constant.LottoConstant.MIN_PURCHASE_AMOUNT;

import java.util.List;

public class LottoPurchase {

    private final List<Lotto> lottos;

    public LottoPurchase(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoPurchase purchase(List<Lotto> lottos) {
        validate(lottos);
        return new LottoPurchase(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static void validate(List<Lotto> lottos) {
        if (lottos == null || lottos.size() < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(MIN_AMOUNT_PURCHASE);
        }

        if (lottos.size() > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_PURCHASE);
        }
    }
}
