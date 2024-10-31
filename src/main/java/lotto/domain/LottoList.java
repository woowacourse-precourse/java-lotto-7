package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoList {

    private final List<Lotto> lottoCollection;

    public LottoList(List<Lotto> lottoCollection) {
        this.lottoCollection = lottoCollection;
    }

    public static LottoList generate(Money money) {
        List<Lotto> lottoCollection = new ArrayList<>();

        while (money.lottoTry()) {
            Lotto lotto = Lotto.generate();
            lottoCollection.add(lotto);
        }

        return new LottoList(lottoCollection);
    }
}
