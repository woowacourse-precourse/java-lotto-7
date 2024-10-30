package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = repeatUntilValidInput(Application::readPurchaseAmount);
    }

    private static <R> R repeatUntilValidInput(Supplier<R> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            System.out.printf("%s\n\n", e.getMessage());
            return repeatUntilValidInput(function);
        }
    }

    private static int parseIntWithIllegalArgumentException(String value, String message) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    private static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountString = Console.readLine();
        System.out.println();
        int purchaseAmount = parseIntWithIllegalArgumentException(purchaseAmountString, "[ERROR] 구입 금액은 숫자여야 합니다.");
        if (purchaseAmount % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        return purchaseAmount;
    }
}
