package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_INFORM_MESSAGE = "구입금액을 입력해주세요.";
    public String getMoney() {
        System.out.println(INPUT_MONEY_INFORM_MESSAGE);

        String input = Console.readLine();
        return input;
    }
}
