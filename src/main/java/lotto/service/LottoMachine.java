package lotto.service;

import lotto.model.lotto.Lottos;
import lotto.model.purchaseAmount.PurchaseAmount;
import lotto.model.winningNumber.BonusNumber;
import lotto.model.winningNumber.WinningNumber;
import lotto.model.winningResult.WinningResults;

public interface LottoMachine {
    Lottos issueLottos(PurchaseAmount purchaseAmount);

    WinningResults checkWinningResults(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber);

    double calculateEarningsRate(WinningResults winningResults, PurchaseAmount purchaseAmount);
}
