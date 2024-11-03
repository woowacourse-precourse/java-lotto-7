package lotto.service.lotto;

import lotto.model.lotto.lottoNumber.Lottos;
import lotto.model.lotto.purchaseAmount.PurchaseAmount;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.winningNumber.WinningNumber;
import lotto.model.lotto.winningResult.WinningResults;

public interface LottoMachine {
    Lottos issueLottos(PurchaseAmount purchaseAmount);

    WinningResults checkWinningResults(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber);

    double calculateEarningsRate(WinningResults winningResults, PurchaseAmount purchaseAmount);
}
