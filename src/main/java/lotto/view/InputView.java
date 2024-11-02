package lotto.view;

import lotto.model.Money;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static void printInputPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static Money inputPurchaseAmount() {
        while (true) {
            try {
                printInputPurchaseAmount();
                long amount = Long.parseLong(readLine());
                return new Money(amount);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
                printRetryMessage();
            }
        }
    }

    public static void printRetryMessage() {
        System.out.println("다시 입력해 주세요.");
    }
}
