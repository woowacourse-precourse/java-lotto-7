package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottoStorage;

    public LottoCollection() {
        this.lottoStorage = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoStorage.add(lotto);
    }

    public List<Lotto> getAllLotto() {
        return lottoStorage;
    }

}
