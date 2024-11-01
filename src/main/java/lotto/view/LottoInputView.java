package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public String getLottoPurchaseMoney() {
        printLottoPurchaseMessage();
        return Console.readLine();
    }

    private void printLottoPurchaseMessage() {
        System.out.println("구입 금액을 입력해주세요");
    }

    public String getWinningNumber() {
        printWinningNumberMessage();
        return null;
    }

    private void printWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
