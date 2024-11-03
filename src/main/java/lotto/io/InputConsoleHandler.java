package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputConsoleHandler {
    public void showBuyingAmountGuideMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int askBuyingAmount() {
        String rawBuyingAmount = Console.readLine();

        return Integer.parseInt(rawBuyingAmount);
    }
}
