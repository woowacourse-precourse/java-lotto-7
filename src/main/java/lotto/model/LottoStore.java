package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.generator.NumberGenerator;

public class LottoStore {
    private NumberGenerator generator;

    public LottoStore(NumberGenerator generator) {
        this.generator = generator;
    }

    public Lottos sellLotto(Money money) {
        int buyCount = money.exchangedForLottos();
        return generateLottos(buyCount);
    }

    private Lottos generateLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        while (buyCount-- > 0) {
            List<Integer> lottoNumbers = generator.generateNumber();
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
