package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readPurchaseAmount(){
        System.out.println("\n구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return InputValidator.validatePurchaseAmount(input);
    }
}
