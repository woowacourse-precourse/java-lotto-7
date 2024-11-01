package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String getPurchaseAmount () {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String getBonusNumber() {
        return Console.readLine();
    }
}
