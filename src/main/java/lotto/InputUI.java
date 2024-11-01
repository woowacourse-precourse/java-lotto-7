package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputUI {
    private InputUI() {
    }

    public static String moneyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String winningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
