package lotto.domain;

import java.util.List;

public class LottoStorage {
    private List<Lotto> lottoNumbers;

    public LottoStorage(List<Lotto> lottos) {
        this.lottoNumbers = lottos;
    }
}
