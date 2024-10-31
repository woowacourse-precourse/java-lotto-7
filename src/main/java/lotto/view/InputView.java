package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.ViewMessages;

public class InputView {

    public String promptMoney() {
        System.out.println(ViewMessages.PROMPT_MONEY.getMessage());
        return Console.readLine();
    }
}
