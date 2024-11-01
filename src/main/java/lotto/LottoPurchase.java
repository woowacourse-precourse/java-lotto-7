package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchase {
    private final int PURCHASE_PRICE = LottoGameInformation.PURCHASE_PRICE.getValue();

    public List<Lotto> purchase(int purchaseAmount) {
        int count = purchaseAmount / PURCHASE_PRICE;
        LottoGenerator LottoGenerator = new LottoGenerator();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }
}
