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

    public String requestWinningNumbers(String winningNumbers) {
        System.out.println("당첨 번호를 입력해 주세요.");
        return winningNumbers;
    }

    public int requestBonusNumber(String bonusNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(bonusNumber);
    }
}
