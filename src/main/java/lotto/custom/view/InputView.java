package lotto.custom.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.custom.constants.PromptMessages;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(PromptMessages.INPUT_PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }
}