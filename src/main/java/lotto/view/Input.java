package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_COST = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public String pay() {
        System.out.println(INPUT_COST);
        return getInputValue();
    }

    public String winningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return getInputValue();
    }

    public String bonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return getInputValue();
    }

    private String getInputValue() {
        return Console.readLine();
    }
}
