package lotto.view;

import static lotto.util.ValidationUtils.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public long getPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해 주세요.");
                String userInput = Console.readLine().trim();

                validateNotEmpty(userInput);
                validateIsNumber(userInput);

                long purchaseAmount = Long.parseLong(userInput);
                validatePositive(purchaseAmount);
                validateThousandUnit(purchaseAmount);

                return purchaseAmount;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력 값이 너무 큽니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
