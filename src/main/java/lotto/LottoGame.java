package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public void start() {
        int purchaseAmount = readPurchaseAmount();

    }

    private int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return validateAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 금액을 입력해주세요.");
        }

        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위의 양수로 입력해 주세요.");
        }

        return amount;
    }
}
