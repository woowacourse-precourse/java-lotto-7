package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.buyer.LottosCount;

public class LottosFactory {
    public static Lottos createCustomLottos(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos generateRandomLottos(final LottosCount LottosCount) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int idx = 0; idx < LottosCount.getLottosCount(); idx++) {
            lottos.add(LottoFactory.createRandomLotto());
        }

        return new Lottos(lottos);
    }
}
