package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputPurchaseAmount() {
        String userInput = Console.readLine();
        return Integer.parseInt(userInput);
    }
}
