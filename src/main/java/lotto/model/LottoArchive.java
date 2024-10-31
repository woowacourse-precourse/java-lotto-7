package lotto.model;

import java.util.List;

public class LottoArchive {
    List<Lotto> lottoList;

    public LottoArchive(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
