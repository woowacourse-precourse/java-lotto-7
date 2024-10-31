package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.validator.InputValidator.validatePurchaseAmount;

public class InputView {

    public static int inputPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = validatePurchaseAmount(input);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
