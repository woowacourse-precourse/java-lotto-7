package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchase {
    public int inputPurchaseAmount() {
        System.out.print("구입금액을 입력해 주세요. : ");
        String input = Console.readLine().trim();
        return Integer.parseInt(input) / 1000;
    }
}