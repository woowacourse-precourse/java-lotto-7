package lotto.purchase;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseInput {

    public String getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
