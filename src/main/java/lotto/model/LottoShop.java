package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final Long LOTTO_PRICE = 1000L;

    public Lottos buyLottos(Money money) {
        long quantity = calculatePurchasableQuantity(money);
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            lottoNumbers.add(LottoGenerator.generateLottoNumbers());
        }

        return Lottos.init(lottoNumbers);
    }

    private long calculatePurchasableQuantity(Money money) {
        return money.divideByUnit(LOTTO_PRICE);
    }
}
