package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String getInputNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String getInputBonusNums() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
