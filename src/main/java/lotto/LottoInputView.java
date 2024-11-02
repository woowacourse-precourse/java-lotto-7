package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView
{
    public static int LottoPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        return amount;
    }
}
