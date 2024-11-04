package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoInput {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return validatePurchaseAmount(Console.readLine());
    }

    private int validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
        return amount;
    }
}
