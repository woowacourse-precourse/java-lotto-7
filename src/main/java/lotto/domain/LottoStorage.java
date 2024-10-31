package lotto.domain;

import java.util.List;

public class LottoStorage {
    private List<Lotto> lottoNumbers;

    public LottoStorage(List<Lotto> lottos) {
        this.lottoNumbers = lottos;
    }

    public void addLotto(Lotto lotto) {
        this.lottoNumbers.add(lotto);
    }
}
