package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_BUDGET_MESSAGE = "구입금액을 입력해 주세요.";

    public String getBudget() {
        System.out.println(ASK_BUDGET_MESSAGE);
        return Console.readLine();
    }
}
