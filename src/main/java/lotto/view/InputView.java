package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.InputConstant;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(InputConstant.ENTER_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(InputConstant.ENTER_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(InputConstant.ENTER_BONUS_NUMBER);
        return Console.readLine();
    }
}
