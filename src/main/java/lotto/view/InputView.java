package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MONEY_INPUT_VIEW = "구입금액을 입력해 주세요.";

    public static int readMoney() {
        System.out.println(MONEY_INPUT_VIEW);
        int input = Integer.parseInt(Console.readLine().trim());

        return input;
    }
}
