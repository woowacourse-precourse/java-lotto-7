package lotto.domain;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottos;

    private LottoBundle(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static LottoBundle of(List<Lotto> lottos){
        return new LottoBundle(lottos);
    }

    public List<Lotto> getLottos(){
        return this.lottos;
    }
}
