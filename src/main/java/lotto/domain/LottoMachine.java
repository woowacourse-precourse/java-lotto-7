package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final NumberGenerater numberGenerater = new NumberGenerater(6);

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(numberGenerater.createRandomNumbers());
    }
}
