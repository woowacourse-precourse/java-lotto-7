package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public String inputMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        return Console.readLine();
    }
}
