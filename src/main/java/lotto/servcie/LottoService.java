package lotto.servcie;

import lotto.model.condition.SpendingMoney;
import lotto.model.BoughtLottos;
import lotto.model.outcome.LottoResult;
import lotto.model.winlotto.WinLotto;

public interface LottoService {

    void buyLotto(SpendingMoney money);
    
    BoughtLottos getLottos();
    
    void createWinStatistics(BoughtLottos boughtLottos, WinLotto winLotto);
    
    LottoResult getResult();

}
