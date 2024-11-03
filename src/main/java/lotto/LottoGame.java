package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();

    public void buyLottos(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(LottoGenerator.generate());
        }
    }
}
