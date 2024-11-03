package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.OutputMessage;

public class InputView {

    public String inputAmountView(){
        System.out.println(OutputMessage.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }
}
