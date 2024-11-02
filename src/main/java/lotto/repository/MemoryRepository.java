package lotto.repository;

import lotto.model.BoughtLottos;
import lotto.model.outcome.LottoResult;

public class MemoryRepository implements Repository {
    
    private BoughtLottos boughtLottos;
    
    private LottoResult result;
    
    @Override
    public void saveLottos(BoughtLottos boughtLottos) {
        this.boughtLottos = boughtLottos;
    }
    
    @Override
    public BoughtLottos getLottos() {
        return this.boughtLottos;
    }
    
    @Override
    public void saveResult(LottoResult result) {
        this.result = result;
    }
    
    @Override
    public LottoResult getResult() {
        return this.result;
    }
}
