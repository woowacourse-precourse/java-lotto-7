package lotto;

import camp.nextstep.edu.missionutils.*;

public class LottoGame {

    private int purchaseAmount;

    public void start() {
        purchaseAmountInput();
    }

    private void purchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println(purchaseAmount);
    }
}
