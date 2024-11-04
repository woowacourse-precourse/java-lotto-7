package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String getPurchaseStr() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseStr = Console.readLine();
        return purchaseStr;
    }

    public static String getWinningNumStr() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumStr = Console.readLine();
        return winningNumStr;
    }

    public static String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumStr = Console.readLine();
        return bonusNumStr;
    }
}
