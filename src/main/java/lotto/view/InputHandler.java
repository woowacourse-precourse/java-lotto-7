package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String getInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String getInputNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
