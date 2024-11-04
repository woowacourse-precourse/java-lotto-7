package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.messageType.InputMessageType;

public class InputMessage {

    public static String inputClientMoney() {
        System.out.println(InputMessageType.INPUT_GUIDE_MESSAGE.getMessage());
        return Console.readLine().trim();
    }

}
