package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoGameInformation;

public class LottoPurchase {
    public List<Lotto> purchase(int purchaseAmount) {
        int count = purchaseAmount / LottoGameInformation.PURCHASE_PRICE;
        LottoGenerator LottoGenerator = new LottoGenerator();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }
}
