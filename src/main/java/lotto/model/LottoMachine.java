package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class LottoMachine {

    private static final int PURCHASE_AMOUNT_UNITS = 1000;
    private static final int LOOP_START_INDEX = 0;

    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> purchaseLottos(int purchaseAmount) {
        int count = purchaseAmount / PURCHASE_AMOUNT_UNITS;

        for (int i = LOOP_START_INDEX; i < count; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            lottos.add(lotto);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
