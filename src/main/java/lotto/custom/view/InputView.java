package lotto.custom.view;

import lotto.custom.constants.PromptMessages;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(PromptMessages.INPUT_PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }
}
