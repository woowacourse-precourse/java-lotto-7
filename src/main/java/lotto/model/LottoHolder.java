package lotto.model;

import java.util.List;

public class LottoHolder {
    LottoCollection lottoCollection;
    
    public LottoHolder(LottoCollection lottoCollection) {
        this.lottoCollection = lottoCollection;
    }
    
    public List<Lotto> getLottos() {
        return lottoCollection.getLottos();
    }
    
}
