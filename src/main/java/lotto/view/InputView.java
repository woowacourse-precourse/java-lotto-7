package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.MoneyValidator;

public class InputView {

    public static int getPurchaseAmount(){
        System.out.println("구입 금액을 입력해 주세요.");

        String input = Console.readLine();
        MoneyValidator.validate(input);

        return Integer.parseInt(input);
    }
}
