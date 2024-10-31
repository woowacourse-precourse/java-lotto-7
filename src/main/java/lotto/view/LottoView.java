package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public int getInputPurchaseAmount() {
        try {
            System.out.println("구매금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());

            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPurchaseAmount();
        }
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
