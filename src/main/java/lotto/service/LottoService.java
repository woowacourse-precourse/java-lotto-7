package lotto.service;

import java.util.List;

public interface LottoService {
    void purchaseLotto(String purchaseAmount);
    List<String> generateLottoLogs();
    double computeProfitRate(String purchaseAmount, String winningNumbers, String bonusNumber);
    List<String> generateWinningReport(String winningNumbers, String bonusNumber);
}
