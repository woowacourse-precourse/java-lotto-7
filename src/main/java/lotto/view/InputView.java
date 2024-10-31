package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private String getConsoleInput() {
        String input = Console.readLine();
        return input;
    }

    public String requestPurchaseAmount(String purchaseAmount) {
        System.out.println("구입금액을 입력해 주세요.");
        return purchaseAmount;
    }
}
