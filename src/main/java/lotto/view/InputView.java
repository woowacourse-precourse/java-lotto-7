package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public long readPurchaseAmount() {
        return Long.parseLong(readInput());
    }

    private String readInput() {
        return Console.readLine();
    }
}
