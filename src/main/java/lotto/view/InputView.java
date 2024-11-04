package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    public static String inputLottoPurchaseMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
