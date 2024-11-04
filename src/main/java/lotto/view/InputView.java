package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static String inputMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String inputNumbers() {
        System.out.println(INPUT_NUMBERS);
        return Console.readLine();
    }
}
