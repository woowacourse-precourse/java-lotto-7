package lotto.view;

import static lotto.view.ViewConstant.INPUT_BONUS_NUMBER;
import static lotto.view.ViewConstant.INPUT_PURCHASE_FEE;
import static lotto.view.ViewConstant.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String purchaseLottery() {
        System.out.println(INPUT_PURCHASE_FEE.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
