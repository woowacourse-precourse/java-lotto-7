package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
    public void start() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine().trim();
            int purchaseAmount = inputPurchaseAmount(input);
            System.out.println();
            System.out.println((purchaseAmount / 1000) + "개를 구매했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            start();
        }
    }

    public int inputPurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }
}
