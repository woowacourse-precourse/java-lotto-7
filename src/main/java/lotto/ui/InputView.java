package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPurchaseAmount() {
        System.out.println(InputPrompts.PURCHASE_PROMPT.getPrompt());
        return Console.readLine().strip();
    }

    public String getLottoNumbers() {
        System.out.println(InputPrompts.LOTTO_NUMBER_PROMPT.getPrompt());
        return Console.readLine().strip();
    }

    public String getBonusNumber() {
        System.out.println(InputPrompts.BONUS_NUMBER_PROMPT.getPrompt());
        return Console.readLine().strip();
    }
}
