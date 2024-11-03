package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        System.out.println();
        return purchasePrice;
    }
}
