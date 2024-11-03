package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;
    private final LottoPurchase lottoPurchase;

    public LottoGame(LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
        this.lottos = generateLotto(lottoPurchase.getLottoCount());
    }

    private List<Lotto> generateLotto(LottoCount lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
