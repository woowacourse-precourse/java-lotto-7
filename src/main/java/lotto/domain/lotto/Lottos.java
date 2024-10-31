package lotto.domain.lotto;

import lotto.domain.lotto.factory.LottoFactory;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final int buyAmount;
    private final List<Lotto> lottos;


    public Lottos(int buyAmount, LottoFactory lottoFactory) {
        this.buyAmount = buyAmount;
        this.lottos = createLottos(buyAmount, lottoFactory);
    }

    private List<Lotto> createLottos(int buyAmount], LottoFactory lottoFactory) {

        List<Lotto> lottos = new ArrayList<>();

        while (lottos.size() < buyAmount) {
            Lotto lotto = Lotto.from(lottoFactory);
            addUnduplicateLotto(lotto);
        }
        return lottos;
    }


    private void addUnduplicateLotto(Lotto lotto) {

        if (!lottos.contains(lotto)) {
            lottos.add(lotto);
        }
    }

}
