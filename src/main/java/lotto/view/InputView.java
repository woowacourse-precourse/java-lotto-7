package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.OutputMessage;

public class InputView {

    public String inputAmountView(){
        System.out.println(OutputMessage.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumbers(){
        System.out.println("\n" + OutputMessage.INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println("\n" + OutputMessage.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
