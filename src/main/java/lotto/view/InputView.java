package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.common.Constants.PURCHASE_AMOUNT_PROMPT;

public class InputView {
    public String getPurchaseAmount () {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
        return Console.readLine();
    }
}
