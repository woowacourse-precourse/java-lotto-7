package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int inputPurchasePrice() {
        String input = Console.readLine();
        checkInput(input);
        int purchasePrice = checkNumber(input);
        checkUnit(purchasePrice);
        return purchasePrice;
    }

    private static void checkInput(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
    }

    private static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }

    private static void checkUnit(int number) {
        if (number < 1000)
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다." + number);
        if(number % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다." + number);
    }
}
