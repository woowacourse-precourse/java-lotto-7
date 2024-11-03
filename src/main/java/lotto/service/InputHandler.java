package lotto.service;

import java.util.List;
import lotto.domain.UserMoney;
import lotto.domain.WinningNumbers;
import lotto.util.Parser;
import lotto.util.Validator;
import lotto.view.InputView;

public class InputHandler {
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
        List<Integer> winningLotto = inputWinningLotto();
        int bonusNumber = inputBonusNumber(winningLotto);

        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private static List<Integer> inputWinningLotto() {
        while (true) {
            try {
                String winningLottoInput = InputView.readWinningLotto();
                List<Integer> winningLotto = Parser.parseToIntegerList(winningLottoInput);
                Validator.validateLotto(winningLotto);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBonusNumber(List<Integer> winningLotto) {
        while (true) {
            try {
                String bonusNumberInput = InputView.readBonusNumber();
                Validator.validateBonusNumber(winningLotto, bonusNumberInput);
                return Integer.parseInt(bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
