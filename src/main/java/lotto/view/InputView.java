package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public void requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return purchaseAmount;

    }

}
