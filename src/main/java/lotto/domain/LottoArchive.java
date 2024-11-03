package lotto.domain;

import java.util.List;

public class LottoArchive {
    List<Lotto> lottoArchive;
    public LottoArchive(List<Lotto> lottos) {
        this.lottoArchive = lottos;
    }
    public List<Lotto> getLottos() {
        return this.lottoArchive;
    }
}