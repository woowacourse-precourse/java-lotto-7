package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validator;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return Validator.validatePurchaseAmount(input);
    }
}
