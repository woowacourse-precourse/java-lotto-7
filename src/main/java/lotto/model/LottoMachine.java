package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class LottoMachine {

    private static final int PURCHASE_AMOUNT_UNITS = 1000;

    private List<Lotto> lottos = new ArrayList<>();

    public void purchaseLottos(int purchaseAmount) {
        int count = purchaseAmount / PURCHASE_AMOUNT_UNITS;

        for (int i = 0; i < count; i ++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            lottos.add(lotto);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
