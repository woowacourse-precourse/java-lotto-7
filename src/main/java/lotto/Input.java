package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int moneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String res = Console.readLine();
        return Integer.parseInt(res);
    }
}
