package lotto.custom.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println(PromptMessages.INPUT_PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println(PromptMessages.INPUT_WINNING_NUMBERS_PROMPT);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println();
        System.out.println(PromptMessages.INPUT_BONUS_NUMBERS_PROMPT);
        return Console.readLine();
    }
}