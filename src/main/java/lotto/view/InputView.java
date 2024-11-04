package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String purchasePrice() {
        return Console.readLine();
    }

    public String winningNumber() {
        return Console.readLine();
    }

    public String bonusNumber() {
        return Console.readLine();
    }
}
