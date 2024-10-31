package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine().trim();
        InputValidator.validatePurchaseAmount(amount);
        return Integer.parseInt(amount);
    }
}
