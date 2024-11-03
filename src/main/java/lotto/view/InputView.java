package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.message.PromptMessage;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println(PromptMessage.PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String readWinningNumbers() {
        System.out.println(PromptMessage.WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(PromptMessage.BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
