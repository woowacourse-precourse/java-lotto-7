package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.ValidatorFactory;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private boolean isPurchased = false;

    public void buyLottos(int count) {
        ValidatorFactory.validatePurchaseState(isPurchased);

        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
        isPurchased = true;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
