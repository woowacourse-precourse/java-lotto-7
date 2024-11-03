package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputPrice() {
        View.printInputPrice();
        return Console.readLine();
    }

    public static String inputWinningNumber() {
        View.printInputWinningNumber();
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        View.printInputBonusNumber();
        return Console.readLine();
    }
}
