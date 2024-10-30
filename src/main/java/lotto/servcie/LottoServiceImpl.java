package lotto.servcie;

import lotto.model.*;
import lotto.repository.Repository;

public class LottoServiceImpl implements LottoService {
    
    private final Repository repository;
    
    public LottoServiceImpl(Repository repository) {
        this.repository = repository;
    }
    
    @Override
    public void buyLotto(SpendingMoney money) {
        BoughtLottos boughtLottos = BoughtLottos.getInstance(money);
        repository.saveLottos(boughtLottos);
    }
    
    @Override
    public BoughtLottos getLottos() {
        return repository.getLottos();
    }
    
    @Override
    public void createWinStatistics(BoughtLottos boughtLottos, WinLotto winLotto) {
        LottoResult result = LottoResult.getInstance(winLotto, boughtLottos);
        repository.saveResult(result);
    }
    
    @Override
    public LottoResult getResult() {
        return repository.getResult();
    }
}
