package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;
    private final LottoPurchase lottoPurchase;
    private final LottoResults lottoResults;


    public LottoGame(LottoPurchase lottoPurchase) {
        this.lottoPurchase = lottoPurchase;
        this.lottos = generateLotto(lottoPurchase.getLottoCount());
        this.lottoResults = new LottoResults();
    }

    private List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottoCount() {
        return lottoPurchase.getLottoCount();
    }
}
