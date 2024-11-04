package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readLine(String message) {
        System.out.println(message);
        String purchaseAmount = Console.readLine();
        System.out.println();

        return purchaseAmount;
    }
}
