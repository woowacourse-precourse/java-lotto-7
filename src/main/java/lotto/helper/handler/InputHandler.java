package lotto.helper.handler;

import java.util.List;
import lotto.helper.util.InputUtil;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.view.error.ErrorView;
import lotto.view.input.InputView;

public class InputHandler {

    public static int inputMoney() {
        while(true) {
            String inputMoney = InputView.inputMoney();
            try {
                return InputUtil.parseMoney(inputMoney);
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static Lotto inputLottoNumbers() {
        while(true) {
            String inputLottoNumbers = InputView.inputLottoNumbers();
            try {
                List<Integer> numbers = InputUtil.splitNumbers(inputLottoNumbers);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static Bonus inputBonusNumber(List<Integer> numbers) {
        while(true) {
            String inputBonusNumber = InputView.inputBonusNumber();
            try {
                int bonus = InputUtil.parseBonusNumber(inputBonusNumber);
                return new Bonus(numbers, bonus);
            } catch (IllegalArgumentException e) {
                ErrorView.printErrorMessage(e.getMessage());
            }
        }
    }
}
