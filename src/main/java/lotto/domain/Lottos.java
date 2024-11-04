package lotto.domain;

import java.util.List;

public class Lottos {
    private static List<Lotto> lottoNumbers;

    public Lottos(List<Lotto> lottos) {
        this.lottoNumbers = lottos;
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}
