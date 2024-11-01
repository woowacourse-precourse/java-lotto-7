package lotto.domain;

import lotto.domain.factory.LottoFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;


    public Lottos(int buyAmount, LottoFactory lottoFactory) {
        this.lottos = createLottos(buyAmount, lottoFactory);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private List<Lotto> createLottos(int buyAmount, LottoFactory lottoFactory) {

        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < buyAmount) {
            Lotto lotto = Lotto.from(lottoFactory);
            addUnduplicateLotto(lottos, lotto);
        }
        return lottos;
    }


    private void addUnduplicateLotto(List<Lotto> lottos, Lotto lotto) {

        if (!lottos.contains(lotto)) {
            lottos.add(lotto);
        }
    }

}
