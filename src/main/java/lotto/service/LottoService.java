package lotto.service;

import java.util.List;
import lotto.model.LottoReport;

public interface LottoService {
    void purchaseLotto(String purchaseAmount);
    List<String> generateLottoLogs();
    LottoReport generateLottoReport(String purchaseAmount, String winningNumbers, String bonusNumber);
}
