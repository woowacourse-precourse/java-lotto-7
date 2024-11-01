package lotto.ui;

import lotto.ui.constants.InputPrompts;

public class InputView {
    public void printPurchasePrompt() {
        System.out.println(InputPrompts.PURCHASE_PROMPT.getPrompt());
    }

    public void printLottoNumberPrompt() {
        System.out.println(InputPrompts.LOTTO_NUMBER_PROMPT.getPrompt());
    }

    public void printBonusNumberPrompt() {
        System.out.println(InputPrompts.BONUS_NUMBER_PROMPT.getPrompt());
    }
}
