package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInputConsole {

    public static PurchaseAmount readPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = parseAmount(input);
        return new PurchaseAmount(amount);
    }

    private static int parseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
}
