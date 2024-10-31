package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getMoneyInput() {
        System.out.println("\n구입 금액을 입력해주세요.");
        return Console.readLine();
    }

    public String getWinningNumbersInput() {
        System.out.println("\n당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public String getBonusNumberInput() {
        System.out.println("\n보너스 번호를 입력해주세요.");
        return Console.readLine();
    }
}
