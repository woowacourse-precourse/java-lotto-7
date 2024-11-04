package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.common.Constants.*;

public class InputView {
    public String getPurchaseAmount () {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    public String getWinningNumbers () {
        System.out.println(WINNING_NUMBER_PROMPT);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_PROMPT);
        return Console.readLine();
    }
}
