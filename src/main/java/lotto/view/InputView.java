package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestPurchaseAmount() {
        return Console.readLine();
    }

    public static String requestWinningNumbers() {
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        return Console.readLine();
    }
}
