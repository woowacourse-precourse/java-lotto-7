package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void displayLottoPurchaseAmountPrompt() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public int readLottoPurchaseAmount() {
        return Integer.parseInt(Console.readLine());
    }

    public void displayWinningNumbersPrompt() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public String readWinningNumbers() {
        return Console.readLine();
    }

    public void displayBonusNumberPrompt() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public String readBonusNumber() {
        return Console.readLine();
    }
}
