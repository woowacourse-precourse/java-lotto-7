package lotto.domain;

import static lotto.constant.Error.MAX_AMOUNT_PURCHASE;
import static lotto.constant.Error.MIN_AMOUNT_PURCHASE;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {

    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public int count() {
        return lottos.size();
    }

    public static LottoPurchase purchase(List<Lotto> lottos) {
        validate(lottos);

        LottoPurchase newLottoPurchase = new LottoPurchase();
        lottos.forEach(newLottoPurchase::add);
        return newLottoPurchase;
    }

    private static void validate(List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException(MIN_AMOUNT_PURCHASE);
        }

        if (lottos.size() > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(MAX_AMOUNT_PURCHASE);
        }
    }
}
