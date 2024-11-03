package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.common.Constants.PURCHASE_AMOUNT_PROMPT;
import static lotto.common.Constants.WINNING_NUMBER_PROMPT;

public class InputView {
    public String getPurchaseAmount () {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    public String getWinningNumbers () {
        System.out.println(WINNING_NUMBER_PROMPT);
        return Console.readLine();
    }
}
