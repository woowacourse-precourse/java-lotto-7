package lotto.domain.lotto;

import lotto.domain.lotto.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final int lottoCount;
    private List<Lotto> lottos;


    public Lottos(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public void makeLottos(LottoFactory lottoFactory) {
        lottos = new ArrayList<>();

        while (lottos.size() < lottoCount) {
            Lotto lotto = Lotto.from(lottoFactory);
            addUnduplicateLotto(lotto);
        }
    }

    private void addUnduplicateLotto(Lotto lotto) {

        if (!lottos.contains(lotto)) {
            lottos.add(lotto);
        }
    }

}
