package lotto.service;

import lotto.domain.UserMoney;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class LottoService {
    public static UserMoney inputUserMoney() {
        while (true) {
            try {
                String userMoneyInput = InputView.readUserMoney();
                return new UserMoney(userMoneyInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                String winningLottoInput = InputView.readWinningLotto();
                String bonusNumberInput = InputView.readBonusNumber();
                return new WinningNumbers(winningLottoInput, bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
