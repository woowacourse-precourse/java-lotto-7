package lotto.view;

import static lotto.constants.OutputMessageConstants.GET_MONEY_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseView {

    public String getMoney() {
        System.out.println(GET_MONEY_MESSAGE);
        return Console.readLine();
    }
}
