package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoView lottoView;
    private final List<Lotto> lottos = new ArrayList<>();

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void start() {
        int purchaseAmount = lottoView.requestPurchaseAmount();
        generateLottos(purchaseAmount);
    }

    private void generateLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / LottoPrice.PRICE.getPrice();
        for(int i = 0; i < lottoCount; i++){
            lottos.add(Lotto.generateRandomLotto());
        }
    }


}
