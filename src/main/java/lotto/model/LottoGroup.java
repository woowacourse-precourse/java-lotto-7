package lotto.model;

import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottos;

    private LottoGroup(List<Lotto> lottoList) {
        this.lottos = List.copyOf(lottoList);
    }

    public static LottoGroup createLottoGroup(List<Lotto> lottoList) {
        return new LottoGroup(lottoList);
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }

    public int getSize(){
        return lottos.size();
    }
}
