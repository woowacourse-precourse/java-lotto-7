package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void getPrice() {
        System.out.println(ViewMessage.AMOUNT_OF_MONEY.getMessage());
        Console.readLine();
    }
}
