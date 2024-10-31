package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStorage {
    private List<Lotto> lottoNumbers;

    public LottoStorage() {
        this.lottoNumbers = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        this.lottoNumbers.add(lotto);
    }
}
