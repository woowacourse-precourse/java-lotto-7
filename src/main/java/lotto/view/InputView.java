package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.InputMessage;

public class InputView {
    public static String getInput(InputMessage message) {
        System.out.println(message.getMessage());
        return Console.readLine();
    }
}
