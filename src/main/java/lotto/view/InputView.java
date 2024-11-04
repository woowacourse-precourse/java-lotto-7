package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {

    public static String requestCost() {
        System.out.println("구입금액을 입력해 주세요.");
        return enterMessage();
    }

    private static String enterMessage() {
        String message = Console.readLine();
        InputValidator.validate(message);
        return message;
    }
}
