package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private final List<Lotto> lottos;

    public static MyLotto createLottos(int purchaseAmount, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        return new MyLotto(lottos);
    }

    private MyLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getMyLottos() {
        return new ArrayList<>(lottos);
    }
}
