package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Constants;
import lotto.enums.ViewMessages;

public class InputView {

    public String promptMoney() {
        System.out.println(ViewMessages.PROMPT_MONEY.getMessage(Constants.MONEY_UNIT.getValue()));
        return Console.readLine();
    }

    public String promptWinningNumbers() {
        System.out.println(ViewMessages.PROMPT_WINNING_NUMBERS.getMessage(Constants.LOTTO_LOWER_BOUND.getValue(),
                Constants.LOTTO_UPPER_BOUND.getValue(),
                Constants.LOTTO_NUMBER_SIZE.getValue()));
        return Console.readLine();
    }

    public String promptBonusNumber() {
        System.out.println(ViewMessages.PROMPT_BONUS_NUMBER.getMessage(Constants.LOTTO_LOWER_BOUND.getValue(),
                Constants.LOTTO_UPPER_BOUND.getValue()));
        return Console.readLine();
    }
}
