package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void displayLottoPurchaseAmountPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int readLottoPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }
}
