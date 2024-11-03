package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPrice() {
        System.out.println(ViewMessage.AMOUNT_OF_MONEY.getMessage());
        return Console.readLine();
    }


}
