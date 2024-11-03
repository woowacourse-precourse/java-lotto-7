package lotto.domain;

import static lotto.constant.Error.MAX_AMOUNT_PURCHASE;
import static lotto.constant.Error.MIN_AMOUNT_PURCHASE;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;
import static lotto.constant.LottoConstant.MIN_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoPurchase {

    private final List<Lotto> lottos = new ArrayList<>();

    public Map<Lotto, Rank> rankLottos(Winning winning) {
        Map<Lotto, Rank> result = new LinkedHashMap<>();
        lottos.forEach(lotto -> result.put(lotto, winning.rank(lotto)));
        return result;
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

    private void add(Lotto lotto) {
        lottos.add(lotto);
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
