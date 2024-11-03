package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        return Console.readLine();
    }
}
