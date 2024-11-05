package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {

    public static String requestAmountToPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public static String requestJackpotNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
