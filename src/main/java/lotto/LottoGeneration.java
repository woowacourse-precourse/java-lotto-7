package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGeneration {
    public static int inputPurchaseAmount() {
        while (true) {
            String input = Console.readLine().trim();
            int amount = parseInputToInteger(input);
            if (amount != -1) {
                return amount;
            }
        }
    }

    private static int parseInputToInteger(String input) {
        try {
            validatePurchaseAmount(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public static void validatePurchaseAmount(String input) {
        if (!Util.isInteger(input)) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000 단위 정수만 입력되야 합니다.");
        }

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 나누어 떨어져야 합니다.");
        }
    }
}
