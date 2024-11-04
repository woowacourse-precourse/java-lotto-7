package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String getLotteryWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String getLotteryBonusNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void closeConsole() {
        Console.close();
    }

}

