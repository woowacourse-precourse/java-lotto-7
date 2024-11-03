package lotto.model;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
    public int getLottoAmount(){
        return lottoBundle.size();
    }
}
