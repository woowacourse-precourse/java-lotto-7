package lotto.servcie;

import lotto.model.SpendingMoney;
import lotto.model.BoughtLottos;
import lotto.model.LottoResult;
import lotto.model.WinLotto;

public interface LottoService {

    void buyLotto(SpendingMoney money);
    
    BoughtLottos getLottos();
    
    void createWinStatistics(BoughtLottos boughtLottos, WinLotto winLotto);
    
    LottoResult getResult();

}
