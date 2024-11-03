package lotto.domain;

import java.util.List;

public class LottoArchive {
    List<Lotto> lottoArchive;
    int lottoAmount;
    public LottoArchive(List<Lotto> lottos, int lottoAmount) {
        this.lottoArchive = lottos;
        this.lottoAmount = lottoAmount;
    }
    public List<Lotto> getLottos() {
        return this.lottoArchive;
    }
    public int getLottoAmount(){
        return this.lottoAmount;
    }
}