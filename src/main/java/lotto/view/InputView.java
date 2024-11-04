package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {

    public static String requestCost() {
        System.out.println("구입금액을 입력해 주세요.");
        return InputValidator.validateCost(enterMessage());
    }

    private static String enterMessage() {
        return InputValidator.validate(Console.readLine());
    }
}
