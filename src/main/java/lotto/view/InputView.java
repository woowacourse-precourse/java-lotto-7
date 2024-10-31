package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String readInput() {
        return Console.readLine();
    }

    public static int readPurchaseAmount() {
        return Integer.parseInt(readInput());
    }
}
