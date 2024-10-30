package lotto.repository;

import lotto.model.BoughtLottos;
import lotto.model.LottoResult;

public interface Repository {
    
    void saveLottos(BoughtLottos boughtLottos);
    
    BoughtLottos getLottos();
    
    void saveResult(LottoResult result);
    
    LottoResult getResult();
}
