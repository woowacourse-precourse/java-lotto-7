package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchasePrice = Console.readLine();
        System.out.println();
        return purchasePrice;
    }

    public String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();
        System.out.println();
        return winningNumbers;
    }
}
