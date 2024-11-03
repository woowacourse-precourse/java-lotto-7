package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
