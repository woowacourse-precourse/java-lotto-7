package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final static int LOTTO_AMOUNT = 1000;
    private final List<Lotto> lottos;

    public Lottos(Amount amount) {
        lottos = new ArrayList<>();
        int lottoCount = calculateLottoCount(amount.getValue());

        for (int i = 1; i <= lottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    private int calculateLottoCount(Integer amount) {
        return amount / LOTTO_AMOUNT;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
