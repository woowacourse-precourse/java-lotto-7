package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;

public class InputView {

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }
}