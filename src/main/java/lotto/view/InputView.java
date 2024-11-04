package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ViewConstant;

public class InputView {

    public String inputPrice() {
        System.out.println(ViewConstant.INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(ViewConstant.INPUT_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(ViewConstant.INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
