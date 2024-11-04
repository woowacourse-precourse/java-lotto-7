package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.SystemConstants;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(SystemConstants.INPUT_VIEW_PROMPT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(SystemConstants.INPUT_VIEW_PROMPT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(SystemConstants.INPUT_VIEW_PROMPT_BONUS_NUMBER);
        return Console.readLine();
    }
}
