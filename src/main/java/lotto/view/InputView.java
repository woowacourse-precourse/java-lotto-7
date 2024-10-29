package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Long inputPurchaseAmount() {
        String userInput = Console.readLine();
        return Long.parseLong(userInput);
    }
}
