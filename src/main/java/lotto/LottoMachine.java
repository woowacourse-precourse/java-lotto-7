package lotto;

import java.util.*;

public class LottoMachine {
    static final int AMOUNT_UNIT = 1000;

    public List<Lotto> issueLottos(int amount) {
        validateAmount(amount);

        int lottoCnt = amount / AMOUNT_UNIT;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private void validateAmount(int amount) {

    }

    private Lotto generateLotto() {
        return null;
    }
}
