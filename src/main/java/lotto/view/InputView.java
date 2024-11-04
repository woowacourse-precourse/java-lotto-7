package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.IOMessage;

public class InputView {

    public String getBuy() {
        System.out.println(IOMessage.BUY_INPUT.getMessage());
        return Console.readLine();
    }

    public String getWinningNum() {
        System.out.println(IOMessage.WINNING_NUM_INPUT.getMessage());
        return Console.readLine();
    }

    public String getBonusNum() {
        System.out.println(IOMessage.BOUNS_NUM_INPUT.getMessage());
        return Console.readLine();
    }
}
