package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String getLotteryWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getLotteryBonusNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public void closeConsole() {
        Console.close();
    }

}

