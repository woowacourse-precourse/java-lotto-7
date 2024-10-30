package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";

    public static String readBudget() {
        System.out.println(INPUT_BUDGET_MESSAGE);
        return Console.readLine();
    }
}
