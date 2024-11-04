package lotto.factory;

import lotto.model.Lotto;
import lotto.model.WinningNumbers;

public class WinningNumbersFactory {
    public static WinningNumbers createWinningNumbers(Lotto winningLotto) {
        return new WinningNumbers(winningLotto);
    }

    public static WinningNumbers createWinningNumbersWithBonusNumber(WinningNumbers existingInstance, int bonusNumber) {
        return existingInstance.createWithBonusNumber(existingInstance, bonusNumber);
    }
}
