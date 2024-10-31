package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputUI {
    private InputUI() {
    }

    public static String moneyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}
