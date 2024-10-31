package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public String requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return purchaseAmount;
    }

    public String requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
