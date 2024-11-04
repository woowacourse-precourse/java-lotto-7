package lotto.view;

import lotto.model.BoughtLottos;
import lotto.model.outcome.LottoResult;

public interface OutputView {
    
    void printLottos(BoughtLottos boughtLottos);
    
    void printResult(LottoResult result);
    
}
