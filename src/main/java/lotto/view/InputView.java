package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.InputValidator;

public class InputView {

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        InputValidator.validateMoney(money);
        return Integer.parseInt(money);
    }
}
